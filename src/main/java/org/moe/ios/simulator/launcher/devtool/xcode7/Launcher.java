/*
Copyright 2014-2016 Intel Corporation

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.moe.ios.simulator.launcher.devtool.xcode7;

import org.moe.common.Port;
import org.moe.common.ShutdownManager;
import org.moe.common.utils.ProxyUtil;
import org.moe.ios.simulator.launcher.Configuration;
import org.moe.ios.simulator.launcher.LauncherInterface;
import org.moe.ios.simulator.launcher.Main;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.general.ptr.impl.PtrFactory;
import org.moe.natj.objc.ObjCException;
import org.moe.natj.objc.ann.Selector;
import mac.NSObject;
import mac.devtools.xcode7.*;
import mac.devtools.xcode7.protocol.IDEConsoleAdaptorDelegateProtocol;
import mac.foundation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Launcher class.
 */
public class Launcher extends NSObject implements LauncherInterface {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

    static {
        NatJ.register();
    }

    /**
     * State for running.
     */
    private boolean isRunning;
    /**
     * Simulated device.
     */
    private SimDevice device;
    /**
     * Application path.
     */
    private File appPath;
    /**
     * Launch configuration.
     */
    private Configuration config;

    /**
     * STD forwarder pipe.
     */
    private PipedOutputStream stdPipeOutput;
    /**
     * STD forwarder file.
     */
    private FileOutputStream stdFileOutput;
    /**
     * STD out file handle.
     */
    private NSFileHandle stdOutFileHandle;

    @Generated
    protected Launcher(Pointer peer) {
        super(peer);
    }

    @Generated
    @Owned
    @Selector("alloc")
    public static native Launcher alloc();

    /**
     * Launches an app on the simulator.
     *
     * @param config launch configuration
     */
    public void launch(Configuration config) {
        DevToolsUtil.init();

        if (config == null || config.getApplicationPath() == null) {
            throw new NullPointerException();
        }
        this.device = SimDevice.getDevice(config.getDeviceUDID(), config);
        this.appPath = config.getApplicationPath();
        this.config = config;
        run();
    }

    public void printDevices(Configuration config) {
        DevToolsUtil.init();

        SimDevice.printDevices(config);
    }

    @Generated
    @Selector("init")
    public native Launcher init();

    private Object killLock = new Object();
    private boolean toKill = false;
    private int pid = -1;

    private void launch(DVTiPhoneSimulator sim) {
        sim.simulatorApplication().sendStartSessionNotificationWithUserInfo(NSDictionary.dictionaryWithObjectForKey(device.UDID().UUIDString(), "deviceUDID"));

        if (config.getStdOutFile() != null) {
            try {
                stdFileOutput = new FileOutputStream(config.getStdOutFile());
                ShutdownManager.registerPost(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            stdFileOutput.close();
                        } catch (IOException ignore) {

                        }
                    }
                });
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Failed to create standard stream forwarding", e);
            }
        }

        Port stdOutPort = config.getStdOutPort();
        if (stdOutPort != null) {
            try {
                stdPipeOutput = new PipedOutputStream();
                final PipedInputStream pipedInputStream = new PipedInputStream(stdPipeOutput);
                ProxyUtil proxyUtil = ProxyUtil.create(stdOutPort.getPort(), pipedInputStream, new OutputStream() {
                    @Override
                    public void write(int b) throws IOException {
                        // Leave empty
                    }
                });
                proxyUtil.registerShutdownHook();
                ShutdownManager.registerPost(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            stdPipeOutput.flush();
                        } catch (IOException ignore) {
                            
                        }
                        try {
                            stdPipeOutput.close();
                        } catch (IOException ignore) {

                        }
                        try {
                            pipedInputStream.close();
                        } catch (IOException ignore) {
                            
                        }
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException("Failed to create standard stream forwarding", e);
            }
        }

        List<String> argArray = config.getLaunchArgs();
        if (config.getJdwpPort() != null) {
            argArray.add(0, "-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=" + config.getJdwpPort().getPort());
        }
        final NSArray args = listAsArray(argArray);

        final NSDictionary envs = mapAsDictionary(config.getEnvVars());

        NSMutableDictionary dict = NSMutableDictionary.dictionaryWithCapacity(3);
        dict.setObjectForKey(appPath.getAbsolutePath(), "LocalBundlePath");
        dict.setObjectForKey(NSNumber.numberWithBool(true), "ShouldInstallApplicationToSimulate");
        dict.setObjectForKey(NSNumber.numberWithBool(config.getWaitForDebugger()), "WaitForDebugger");

        Ptr<NSError> err = PtrFactory.newObjectReference(NSError.class);
        final IDEPseudoTerminal term = IDEPseudoTerminal.alloc().initWithAccessModeOwnsSlaveFileDescriptorError(2, false, err);
        NSError errObj = err.get();
        if (errObj != null) {
            throw new RuntimeException("Creation of pseudo terminal failed with error, "+ errObj);
        }

        try {
            IDEConsoleAdaptor.alloc().
                    initWithTypeStandardInputStandardOutputStandardError(
                            IDE.kIDEConsoleAdaptorTarget(),
                            term.masterFileHandle(), term.masterFileHandle(),
                            term.masterFileHandle()).setDelegate(new IDEConsoleAdaptorDelegateProtocol() {
                @Override
                @Selector("parseConsoleInputFromOriginalInput:")
                public String parseConsoleInputFromOriginalInput(String input) {
                    return null;
                }

                @Override
                @Selector("parseConsoleOutputFromOriginalOutput:")
                public String parseConsoleOutputFromOriginalOutput(String output) {
                    if (stdPipeOutput != null) {
                        try {
                            stdPipeOutput.write(output.getBytes());
                        } catch (IOException e) {
                            LOG.error("Failed to pipe standard stream");
                        }
                    }
                    if (stdFileOutput != null) {
                        try {
                            stdFileOutput.write(output.getBytes());
                        } catch (IOException e) {
                            LOG.error("Failed to write standard stream");
                        }
                    }
                    System.out.print(output);

                    return null;
                }
            });
        } catch (ObjCException ex) {
            throw new RuntimeException("Failed to register observers for stdout!", ex);
        }

        SignalHandler handler = new SignalHandler() {
            @Override
            public void handle(Signal signal) {
                synchronized (killLock) {
                    if (isRunning && !toKill) {
                        toKill = true;
                        if (pid >= 0) {
                            SysHelper.kill(pid, 2);
                        }
                    }
                }
            }
        };

        final SignalHandler oldTermHandler = Signal.handle(new Signal("TERM"), handler);
        final SignalHandler oldIntHandler = Signal.handle(new Signal("INT"), handler);

        try {
            err = PtrFactory.newObjectReference(NSError.class);
            sim.launchSimulatedExecutableLaunchServiceError(dict, new Object() {

                @Selector("pty")
                public Object pty() {
                    return term;
                }

                @Selector("executionDidEnd")
                public void executionDidEnd() {
                    isRunning = false;
                    Signal.handle(new Signal("TERM"), oldTermHandler);
                    Signal.handle(new Signal("INT"), oldIntHandler);
                }

                @Selector("launchCompleteWithAppPID:")
                public void launchCompleteWithAppPID(int pid) {
                    synchronized (killLock) {
                        Launcher.this.pid = pid;
                        if (toKill) {
                            SysHelper.kill(pid, 2);
                        }
                    }
                }

                @Selector("isLaunchingToDebug")
                public boolean isLaunchingToDebug() {
                    return false;
                }

                @Selector("launchSession")
                public Object launchSession() {

                    return new Object() {
                        @Selector("setSimulatorPID:")
                        public void setSimulatorPID(int pid) {}

                        @Selector("launchParameters")
                        public Object launchParameters() {
                            return new Object() {
                                @Selector("environmentVariables")
                                public NSDictionary environmentVariables() {
                                    return envs;
                                }

                                @Selector("commandLineArgs")
                                public NSArray commandLineArgs() {
                                    return args;
                                }

                                @Selector("productType")
                                public Object productType() {
                                    return new Object() {
                                        @Selector("isWatchApplication")
                                        public boolean isWatchApplication() {
                                            return false;
                                        }
                                    };
                                }
                            };
                        }
                    };
                }

            }, err);
            errObj = err.get();
            if (errObj != null) {
                throw new RuntimeException("Launching application failed with error, " + errObj);
            }
        } catch (ObjCException ex) {
            throw new RuntimeException("Could not launch application!", ex);
        }
    }

    /**
     * Launches the app.
     */
    private void run() {
        if (!appPath.exists() || !appPath.isDirectory()) {
            throw new IllegalArgumentException("Invalid app file");
        }

        Main.PRINT_CONTROL("Launching:");

        final DVTiPhoneSimulator sim = DVTiPhoneSimulator.simulatorWithDevice(device);
        try {
            Ptr<NSError> err = PtrFactory.newObjectReference(NSError.class);
            sim.simulatorApplication().launchWithErrorAndReadyCallback(err, new DVTSimulatorApplication.Block_launchWithErrorAndReadyCallback() {
                @Override
                public void call_launchWithErrorAndReadyCallback() {
                    launch(sim);
                }
            });
            NSError errObj = err.get();
            if (errObj != null) {
                throw new RuntimeException("Launching Simulator failed with error, " + errObj);
            }
        } catch(ObjCException ex) {
            throw new RuntimeException("Could not launch Simulator!", ex);
        }

        isRunning = true;
        while (isRunning) {
            NSRunLoop.mainRunLoop().runUntilDate(NSDate.dateWithTimeIntervalSinceNow(1.0));
        }

        NSRunLoop.mainRunLoop().runUntilDate(NSDate.dateWithTimeIntervalSinceNow(2.0));

        // Shutdown
        ShutdownManager.shutdown();
    }

    /**
     * Converts the specified list to an NSArray.
     *
     * @param list list to convert
     * @return NSArray
     */
    private NSArray listAsArray(List<String> list) {
        NSMutableArray array = NSMutableArray.array().init();
        for (String arg : list) {
            array.addObject(arg);
        }
        return array;
    }

    /**
     * Converts the specified list to an NSDictionary.
     *
     * @param map map to convert
     * @return NSDictionary
     */
    private NSDictionary mapAsDictionary(Map<String, String> map) {
        NSMutableDictionary dict = NSMutableDictionary.alloc().init();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            dict.setObjectForKey(next.getValue(), next.getKey());
        }
        return dict;
    }

}
