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

package org.moe.ios.simulator.launcher;

import org.moe.common.configuration.ConfigurationValidationException;
import org.moe.common.utils.NativeUtil;
import mac.foundation.NSBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Main class.
 */
public class Main {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private static void loadNativeLibraries() throws IOException {
        String current = new java.io.File( "." ).getCanonicalPath();

        String osName = NativeUtil.getUnifiedSystemName();

        if(osName.equals(NativeUtil.OS_NAME_MAC_OS_X)) {
            System.load(current + "/macosx/x86_64/libnatj.dylib");
        }
        else {
            throw new RuntimeException("Unsupported OS");
        }
    }

    /**
     * Configuration to launch.
     */
    private final Configuration config;

    /**
     * Create a new Main instance.
     *
     * @param config configuration to launch
     */
    private Main(Configuration config) {
        if (config == null) {
            throw new NullPointerException();
        }
        this.config = config;
    }

    public static void main(String[] args) throws IOException {
        // Read configuration
        Configuration config = ConfigurationAppender.read(args);
        try {
            config.validate();
            config.close();
        } catch (ConfigurationValidationException ex) {
            PRINT_ERROR("Invalid property (" + ex.getPropertyName() + ") - " + ex.getErrorMessage());
            System.exit(1);
        }

        loadNativeLibraries();

        // Launch
        Main main = new Main(config);
        try {
            main.run();
        } catch (Exception e) {
            PRINT_ERROR("Launching failed, " + e.getMessage());
            LOG.debug("Launching failed", e);
            System.exit(1);
        }
    }

    /**
     * Returns the currently selected developer Xcode environment.
     */
    public static String getXcodePath() {
        String path = System.getenv("DEVELOPER_DIR");
        if (path != null && path.length() > 0) {
            return path;
        }

        ProcessBuilder pb = new ProcessBuilder("/usr/bin/xcode-select", "-print-path");
        Process p;
        try {
            p = pb.start();
            InputStream pis = p.getInputStream();
            if (pis == null) {
                throw new IOException();
            }
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(pis));
                path = input.readLine();
                p.waitFor();
            } finally {
                try {
                    pis.close();
                } catch (IOException ignore) {
                    
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Failed to get Xcode Developer path");
        }
        if (p.exitValue() != 0 || path == null || path.length() == 0) {
            throw new RuntimeException("Failed to get Xcode Developer path");
        }
        return path;
    }

    /**
     * Run the launcher.
     */
    private void run() {
        LauncherInterface launcher;
        try {
            String xcodeBundlePath = new File(getXcodePath()).getParentFile().getParentFile().getCanonicalPath();
            String versionString = (String)NSBundle.bundleWithPath(xcodeBundlePath).objectForInfoDictionaryKey("CFBundleShortVersionString");
            String major = versionString.split("\\.")[0];
            Class<?> cls = Class.forName("org.moe.ios.simulator.launcher.devtool.xcode" + major + ".Launcher");
            launcher = (LauncherInterface)cls.getDeclaredMethod("init").invoke(cls.getDeclaredMethod("alloc").invoke(null));
        } catch(Exception ex) {
            throw new RuntimeException("Unable to initialize launcher!", ex);
        }

        if (config.getListDevices()) {
            PRINT_CONTROL("Available iOS Simulators:");
            launcher.printDevices(config);
            PRINT_CONTROL("");
        }

        launcher.launch(config);
    }

    /**
     * Prints a control related string on std out.
     *
     * @param ctrlString control string
     */
    public static void PRINT_CONTROL(String ctrlString) {
        if (ctrlString == null) {
            ctrlString = "";
        }
        System.out.println(ctrlString);
        System.out.flush();
    }

    /**
     * Prints an error related string on std err, with ERROR: prefix.
     *
     * @param errString error string
     */
    public static void PRINT_ERROR(String errString) {
        if (errString == null) {
            errString = "";
        }
        errString = "ERROR: " + errString;
        System.err.println(errString);
        System.err.flush();
    }
}
