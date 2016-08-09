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

import org.moe.common.Port;
import org.moe.common.configuration.AbstractConfiguration;
import org.moe.common.configuration.ConfigurationValidationException;
import org.moe.common.utils.ArrayUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * iOS Device launch configuration.
 */
public class Configuration extends AbstractConfiguration {

    /*
     Configuration property names.
     */
    public static final String DEVICE_UDID_PROPERTY_NAME = "Device UDID";
    public static final String APPLICATION_PATH_PROPERTY_NAME = "Application Path";
    public static final String LIST_DEVICES_PROPERTY_NAME = "List Devices";
    public static final String ADD_LAUNCH_ARG_PROPERTY_NAME = "Add Launch Argument";
    public static final String ADD_ENV_VAR_PROPERTY_NAME = "Add Env Variable";
    public static final String JDWP_PORT_PROPERTY_NAME = "JDWP Port";
    public static final String STD_OUT_PROPERTY_NAME = "STD Out";
    public static final String STD_OUT_FILE_PROPERTY_NAME = "STD Out File";
    public static final String DONT_ACTIVATE_PROPERTY_NAME = "Don't Activate";
    public static final String WAIT_FOR_DEBUGGER_PROPERTY_NAME = "Wait for Debugger";
    public static final String TARGET_PLATFORM_TVOS_PROPERTY_NAME = "Target Platform tvOS";
    public static final String TARGET_PLATFORM_WATCHOS_PROPERTY_NAME = "Target Platform watchOS";

    /**
     * Launch arguments.
     */
    private final ArrayList<String> launchArgs = new ArrayList<String>();
    /**
     * Launch arguments.
     */
    private final HashMap<String, String> envVars = new HashMap<String, String>();
    /**
     * Device UDID.
     */
    private String deviceUDID;
    /**
     * Application path.
     */
    private File applicationPath;
    /**
     * List devices.
     */
    private boolean listDevices;
    /**
     * Proxy port for jdwp.
     */
    private Port jdwpPort;
    /**
     * STD out port.
     */
    private Port stdOutPort;
    /**
     * STD out file.
     */
    private File stdOutFile;
    /**
     * Don't activate flag.
     */
    private boolean dontActivate;
    /**
     * Wait for debugger flag.
     */
    private boolean waitForDebugger;
    /**
     * Target platform tvOS flag.
     */
    private boolean targetPlatformTvOS;
    /**
     * Target platform watchOS flag.
     */
    private boolean targetPlatformWatchOS;

    /**
     * Creates a new Configuration instance.
     */
    public Configuration() {
    }

    /**
     * Returns the device UDID.
     *
     * @return device UDID
     */
    public String getDeviceUDID() {
        return deviceUDID;
    }

    /**
     * Sets the device UDID.
     *
     * @param deviceUDID device UDID
     */
    public void setDeviceUDID(String deviceUDID) {
        requireOpen();
        this.deviceUDID = deviceUDID;
    }

    /**
     * Returns the application path.
     *
     * @return application path
     */
    public File getApplicationPath() {
        return applicationPath;
    }

    /**
     * Sets the application path.
     *
     * @param applicationPath application path
     */
    public void setApplicationPath(File applicationPath) {
        requireOpen();
        this.applicationPath = applicationPath;
    }

    /**
     * Returns the list devices flag.
     *
     * @return list devices flag
     */
    public boolean getListDevices() {
        return listDevices;
    }

    /**
     * Sets the list devices flag.
     *
     * @param listDevices list devices flag
     */
    public void setListDevices(boolean listDevices) {
        requireOpen();
        this.listDevices = listDevices;
    }

    /**
     * Returns the list of launch arguments.
     *
     * @return list of launch arguments
     */
    public ArrayList<String> getLaunchArgs() {
        return new ArrayList<String>(launchArgs);
    }

    /**
     * Adds a new launch argument.
     *
     * @param arg launch argument
     */
    public void addLaunchArg(String arg) {
        requireOpen();
        launchArgs.add(arg);
    }

    /**
     * Returns the env vars' map.
     *
     * @return env vars' map
     */
    public HashMap<String, String> getEnvVars() {
        return new HashMap<String, String>(envVars);
    }

    /**
     * Adds a new env var.
     *
     * @param key   key
     * @param value value
     */
    public void addEnvVar(String key, String value) {
        requireOpen();
        envVars.put(key, value);
    }

    /**
     * Returns the JDWP proxy port.
     *
     * @return JDWP proxy port
     */
    public Port getJdwpPort() {
        return jdwpPort;
    }

    /**
     * Sets the JDWP proxy port.
     *
     * @param jdwpPort JDWP proxy port
     */
    public void setJdwpPort(Port jdwpPort) {
        requireOpen();
        this.jdwpPort = jdwpPort;
    }

    /**
     * Returns the STD out port.
     *
     * @return STD out port.
     */
    public Port getStdOutPort() {
        return stdOutPort;
    }

    /**
     * Sets the STD out port.
     *
     * @param stdOutPort STD out port
     */
    public void setStdOutPort(Port stdOutPort) {
        requireOpen();
        this.stdOutPort = stdOutPort;
    }

    /**
     * Returns the STD out file.
     *
     * @return STD out file.
     */
    public File getStdOutFile() {
        return stdOutFile;
    }

    /**
     * Sets the STD out file.
     *
     * @param stdOutFile STD out file
     */
    public void setStdOutFile(File stdOutFile) {
        this.stdOutFile = stdOutFile;
    }

    /**
     * Returns the 'don't activate' flag.
     *
     * @return 'don't activate' flag
     */
    public boolean getDontActivate() {
        return dontActivate;
    }

    /**
     * Sets the 'don't activate' flag.
     *
     * @param dontActivate 'don't activate' flag
     */
    public void setDontActivate(boolean dontActivate) {
        requireOpen();
        this.dontActivate = dontActivate;
    }

    /**
     * Returns the wait for debugger flag.
     *
     * @return wait for debugger flag
     */
    public boolean getWaitForDebugger() {
        return waitForDebugger;
    }

    /**
     * Sets the wait for debugger flag.
     *
     * @param waitForDebugger wait for debugger flag
     */
    public void setWaitForDebugger(boolean waitForDebugger) {
        requireOpen();
        this.waitForDebugger = waitForDebugger;
    }

    /**
     * Returns the target platform tvOS flag.
     *
     * @return target platform tvOS flag
     */
    public boolean getTargetPlatformTvOS() {
        return targetPlatformTvOS;
    }

    /**
     * Sets the target platform tvOS flag.
     *
     * @param targetPlatformTvOS target platform tvOS flag
     */
    public void setTargetPlatformTvOS(boolean targetPlatformTvOS) {
        requireOpen();
        this.targetPlatformTvOS = targetPlatformTvOS;
    }

    /**
     * Returns the target platform watchOS flag.
     *
     * @return target platform watchOS flag
     */
    public boolean getTargetPlatformWatchOS() {
        return targetPlatformWatchOS;
    }

    /**
     * Sets the target platform watchOS flag.
     *
     * @param targetPlatformWatchOS target platform watchOS flag
     */
    public void setTargetPlatformWatchOS(boolean targetPlatformWatchOS) {
        requireOpen();
        this.targetPlatformWatchOS = targetPlatformWatchOS;
    }

    @Override
    public void validate() throws ConfigurationValidationException {
        if (getDeviceUDID() != null) {
            assertNotEmpty(DEVICE_UDID_PROPERTY_NAME, deviceUDID);
        }

        if (!getListDevices()) {
            // Only required if installing is the only action
            assertNotNull(APPLICATION_PATH_PROPERTY_NAME, applicationPath);
        }
        assertDirectoryExists(APPLICATION_PATH_PROPERTY_NAME, applicationPath);
    }

    @Override
    public Object getProperty(String key) {
        if (DEVICE_UDID_PROPERTY_NAME.equals(key)) {
            return getDeviceUDID();
        } else if (APPLICATION_PATH_PROPERTY_NAME.equals(key)) {
            return getApplicationPath();
        } else if (LIST_DEVICES_PROPERTY_NAME.equals(key)) {
            return getListDevices();
        } else if (ADD_LAUNCH_ARG_PROPERTY_NAME.equals(key)) {
            throw new IllegalArgumentException("write only arg");
        } else if (ADD_ENV_VAR_PROPERTY_NAME.equals(key)) {
            throw new IllegalArgumentException("write only arg");
        } else if (JDWP_PORT_PROPERTY_NAME.equals(key)) {
            return getJdwpPort();
        } else if (STD_OUT_PROPERTY_NAME.equals(key)) {
            return getStdOutPort();
        } else if (STD_OUT_FILE_PROPERTY_NAME.equals(key)) {
            return getStdOutFile();
        } else if (DONT_ACTIVATE_PROPERTY_NAME.equals(key)) {
            return getDontActivate();
        } else if (WAIT_FOR_DEBUGGER_PROPERTY_NAME.equals(key)) {
            return getWaitForDebugger();
        } else if (TARGET_PLATFORM_TVOS_PROPERTY_NAME.equals(key)) {
            return getTargetPlatformTvOS();
        } else if (TARGET_PLATFORM_WATCHOS_PROPERTY_NAME.equals(key)) {
            return getTargetPlatformWatchOS();
        } else {
            return super.getProperty(key);
        }
    }

    @Override
    public void setProperty(String key, Object value) {
        if (DEVICE_UDID_PROPERTY_NAME.equals(key)) {
            setDeviceUDID((String) value);
        } else if (APPLICATION_PATH_PROPERTY_NAME.equals(key)) {
            setApplicationPath((File) value);
        } else if (LIST_DEVICES_PROPERTY_NAME.equals(key)) {
            setListDevices((Boolean) value);
        } else if (ADD_LAUNCH_ARG_PROPERTY_NAME.equals(key)) {
            addLaunchArg((String) value);
        } else if (ADD_ENV_VAR_PROPERTY_NAME.equals(key)) {
            String kv = (String) value;
            int idx = kv.indexOf('=');
            if (idx == -1) {
                addEnvVar(kv, "");
            } else {
                addEnvVar(kv.substring(0, idx), kv.substring(idx + 1));
            }
        } else if (JDWP_PORT_PROPERTY_NAME.equals(key)) {
            setJdwpPort((Port) value);
        } else if (STD_OUT_PROPERTY_NAME.equals(key)) {
            setStdOutPort((Port) value);
        } else if (STD_OUT_FILE_PROPERTY_NAME.equals(key)) {
            setStdOutFile((File) value);
        } else if (DONT_ACTIVATE_PROPERTY_NAME.equals(key)) {
            setDontActivate((Boolean) value);
        } else if (WAIT_FOR_DEBUGGER_PROPERTY_NAME.equals(key)) {
            setWaitForDebugger((Boolean) value);
        } else if (TARGET_PLATFORM_TVOS_PROPERTY_NAME.equals(key)) {
            setTargetPlatformTvOS((Boolean) value);
        } else if (TARGET_PLATFORM_WATCHOS_PROPERTY_NAME.equals(key)) {
            setTargetPlatformWatchOS((Boolean) value);
        } else {
            super.setProperty(key, value);
        }
    }

    @Override
    public Class<?> getPropertyClass(String key) {
        if (DEVICE_UDID_PROPERTY_NAME.equals(key)) {
            return String.class;
        } else if (APPLICATION_PATH_PROPERTY_NAME.equals(key)) {
            return File.class;
        } else if (LIST_DEVICES_PROPERTY_NAME.equals(key)) {
            return Boolean.class;
        } else if (ADD_LAUNCH_ARG_PROPERTY_NAME.equals(key)) {
            return String.class;
        } else if (ADD_ENV_VAR_PROPERTY_NAME.equals(key)) {
            return String.class;
        } else if (JDWP_PORT_PROPERTY_NAME.equals(key)) {
            return Port.class;
        } else if (STD_OUT_PROPERTY_NAME.equals(key)) {
            return Port.class;
        } else if (STD_OUT_FILE_PROPERTY_NAME.equals(key)) {
            return File.class;
        } else if (DONT_ACTIVATE_PROPERTY_NAME.equals(key)) {
            return Boolean.class;
        } else if (WAIT_FOR_DEBUGGER_PROPERTY_NAME.equals(key)) {
            return Boolean.class;
        } else if (TARGET_PLATFORM_TVOS_PROPERTY_NAME.equals(key)) {
            return Boolean.class;
        } else if (TARGET_PLATFORM_WATCHOS_PROPERTY_NAME.equals(key)) {
            return Boolean.class;
        } else {
            return super.getPropertyClass(key);
        }
    }

    @Override
    public String[] getAllPropertyNames() {
        return ArrayUtil.concatenate(super.getAllPropertyNames(),
                new String[]{
                        DEVICE_UDID_PROPERTY_NAME,
                        APPLICATION_PATH_PROPERTY_NAME,
                        LIST_DEVICES_PROPERTY_NAME,
                        ADD_LAUNCH_ARG_PROPERTY_NAME,
                        ADD_ENV_VAR_PROPERTY_NAME,
                        JDWP_PORT_PROPERTY_NAME,
                        STD_OUT_PROPERTY_NAME,
                        STD_OUT_FILE_PROPERTY_NAME,
                        DONT_ACTIVATE_PROPERTY_NAME,
                        WAIT_FOR_DEBUGGER_PROPERTY_NAME,
                        TARGET_PLATFORM_TVOS_PROPERTY_NAME,
                        TARGET_PLATFORM_WATCHOS_PROPERTY_NAME,
                });
    }
}
