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

package org.moe.ios.simulator.launcher.devtool.xcode6;

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
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.Selector;
import mac.NSObject;
import mac.appkit.NSRunningApplication;
import mac.devtools.xcode6.*;
import mac.devtools.xcode6.protocol.DTiPhoneSimulatorSessionDelegate;
import mac.foundation.*;
import mac.foundation.c.Foundation;
import mac.foundation.enums.Enums;
import mac.sys.c.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Launcher class.
 */
public class Launcher extends NSObject implements DTiPhoneSimulatorSessionDelegate, LauncherInterface {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

    static {
        NatJ.register();
    }

    /**
     * State lock for shutting down.
     */
    private final Lock stateLock = new ReentrantLock();
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
     * Simulator session.
     */
    private DTiPhoneSimulatorSession session;
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

    /**
     * Launches the app.
     */
    private void run() {
        if (!appPath.exists() || !appPath.isDirectory()) {
            throw new IllegalArgumentException("Invalid app file");
        }

        Main.PRINT_CONTROL("Launching:");

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

        DTiPhoneSimulatorApplicationSpecifier spec = DTiPhoneSimulatorApplicationSpecifier.specifierWithApplicationPath(appPath.getAbsolutePath());
        if (spec == null) {
            throw new RuntimeException("Failed to create app spec");
        }
        DTiPhoneSimulatorSessionConfig sessionConf = DTiPhoneSimulatorSessionConfig.alloc().init();
        if (sessionConf == null) {
            throw new RuntimeException("Failed to create session config");
        }
        DTiPhoneSimulatorSystemRoot systemRoot = DTiPhoneSimulatorSystemRoot.rootWithSimRuntime(device.runtime());
        if (systemRoot == null) {
            throw new RuntimeException("Failed to create system root");
        }

        sessionConf.setApplicationToSimulateOnStart(spec);
        sessionConf.setSimulatedSystemRoot(systemRoot);
        sessionConf.setSimulatedApplicationShouldWaitForDebugger(false);

        ArrayList<String> _args = new ArrayList<String>();
        if (config.getJdwpPort() != null) {
            _args.add("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=" + config.getJdwpPort().getPort());
        }
        _args.addAll(config.getLaunchArgs());
        sessionConf.setSimulatedApplicationLaunchArgs(listAsArray(_args));
        sessionConf.setSimulatedApplicationLaunchEnvironment(mapAsDictionary(config.getEnvVars()));

        sessionConf.setLocalizedClientName("moe");
        sessionConf.setDevice(device);

        if (config.getWaitForDebugger()) {
            sessionConf.setSimulatedApplicationShouldWaitForDebugger(true);
        }

        String fifo = mkfifo();
        sessionConf.setSimulatedApplicationStdOutPath(fifo);
        sessionConf.setSimulatedApplicationStdErrPath(fifo);

        session = DTiPhoneSimulatorSession.alloc().init();
        if (session == null) {
            throw new RuntimeException("Failed to create session");
        }
        session.setDelegate(this);

        if (!session.requestStartWithConfigTimeoutError(sessionConf, 0.0, null)) {
            throw new RuntimeException("Failed to start session");
        }

        while (true) {
            NSRunLoop.mainRunLoop().runUntilDate(NSDate.dateWithTimeIntervalSinceNow(1.0));
            stateLock.lock();
            try {
                if (session == null) {
                    break;
                }
            } finally {
                stateLock.unlock();
            }
        }
        // Add an additional 2 secs for std stream to finish
        NSRunLoop.mainRunLoop().runUntilDate(NSDate.dateWithTimeIntervalSinceNow(2.0));

        // Shutdown
        ShutdownManager.shutdown();
    }

    private String mkfifo() {
        String tmp = Foundation.NSTemporaryDirectory();
        String path = tmp + "/moe-stdout-pipe-" + new Date().getTime();
        if (Globals.mkfifo(path, (short) (0000400 | 0000200)) == -1) {
            throw new RuntimeException("Failed to create fifo for stdout forwarding: " + path);
        }

        // Read handle
        int fd = SysHelper.open(path, 0x0000 /* O_RDONLY */ | 0x0004 /* O_NONBLOCK */);
        NSFileHandle handle = NSFileHandle.alloc().initWithFileDescriptor(fd);
        handle.readInBackgroundAndNotify();
        NSNotificationCenter center = (NSNotificationCenter) NSNotificationCenter.defaultCenter();
        center.addObserverSelectorNameObject(this, new SEL("stdioDataIsAvailable:"), Foundation.NSFileHandleReadCompletionNotification(), handle);
        stdOutFileHandle = handle;

        // Create parent if needed
        File linkFile = new File((String) device.dataPath(), path);
        if (!linkFile.getParentFile().exists()) {
            linkFile.getParentFile().mkdirs();
        }
        String link = linkFile.getAbsolutePath();
        NSFileManager fileManager = NSFileManager.defaultManager();
        if (!fileManager.createSymbolicLinkAtPathWithDestinationPathError(link, path, null)) {
            throw new RuntimeException("Failed to create fifo link for stdout forwarding");
        }
        return path;
    }

    @Selector("stdioDataIsAvailable:")
    private void stdioDataIsAvailable(NSNotification notif) {
        NSFileHandle handle = (NSFileHandle) notif.object();
        handle.readInBackgroundAndNotify();

        NSData data = (NSData) notif.userInfo().objectForKey(Foundation.NSFileHandleNotificationDataItem());
        if (data.length() == 0) {
            return;
        }

        NSString str = NSString.alloc().initWithDataEncoding(data, Enums.NSUTF8StringEncoding);
        if (stdPipeOutput != null) {
            try {
                stdPipeOutput.write(str.toString().getBytes());
            } catch (IOException e) {
                LOG.error("Failed to pipe standard stream");
            }
        }
        if (stdFileOutput != null) {
            try {
                stdFileOutput.write(str.toString().getBytes());
            } catch (IOException e) {
                LOG.error("Failed to write standard stream");
            }
        }
        System.out.print(str.toString());
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

    @Override
    @Selector("session:didEndWithError:")
    public void sessionDidEndWithError(DTiPhoneSimulatorSession session, NSError error) {
        if (error != null) {
            LOG.error("Session ended with error: " + error);
            System.exit(1);
        }
        interrupt();
    }

    @Override
    @Selector("session:didStart:withError:")
    public void sessionDidStartWithError(DTiPhoneSimulatorSession session, boolean started, NSError error) {
        if (started) {
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    interrupt();
                }
            }));
            if (!config.getDontActivate()) {
	            int pid = session.simulatorPID();
				NSRunningApplication simApp = NSRunningApplication.runningApplicationWithProcessIdentifier(pid);
				simApp.activateWithOptions(mac.appkit.enums.Enums.NSApplicationActivateIgnoringOtherApps);
            }
        } else {
            LOG.error("Session start failed error: " + error);
            System.exit(1);
        }
    }

    /**
     * Shuts down the simulator.
     */
    private void interrupt() {
        stateLock.lock();
        try {
            if (session != null) {
                session.requestEndWithTimeout(0);
                session = null;
            }
        } finally {
            stateLock.unlock();
        }
    }
}
