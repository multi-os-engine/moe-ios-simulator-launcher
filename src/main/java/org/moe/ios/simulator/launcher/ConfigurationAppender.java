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

import org.moe.common.configuration.AbstractConfigurationAppender;

/**
 * iOS Device launch configuration appender.
 */
public class ConfigurationAppender extends AbstractConfigurationAppender {

    /**
     * Creates a new ConfigurationAppender instance.
     *
     * @param configuration configuration to append to
     */
    private ConfigurationAppender(Configuration configuration) {
        super(configuration);
    }

    /**
     * Reads arguments from a string array and creates a configuration object for it.
     *
     * @param args arguments
     * @return Configuration instance
     */
    public static Configuration read(String[] args) {
        Configuration conf = new Configuration();
        ConfigurationAppender reader = new ConfigurationAppender(conf);
        reader.set(args);
        return conf;
    }

    @Override
    protected void setup() {
        addOptionWithArg("-u", Configuration.DEVICE_UDID_PROPERTY_NAME);
        addOptionWithArg("--udid", Configuration.DEVICE_UDID_PROPERTY_NAME);
        addHelp(Configuration.DEVICE_UDID_PROPERTY_NAME,
                "--udid=afb5fab15af51b6afba1fba65fb1a6af56b16af1",
                "Set device UDID to attach to.");

        addOptionWithArg("-a", Configuration.APPLICATION_PATH_PROPERTY_NAME);
        addOptionWithArg("--app-path", Configuration.APPLICATION_PATH_PROPERTY_NAME);
        addHelp(Configuration.APPLICATION_PATH_PROPERTY_NAME,
                "--app-path=/my/file/superapp.app",
                "Set the application to run.");

        addOptionWithValue("-l", Configuration.LIST_DEVICES_PROPERTY_NAME, Boolean.TRUE);
        addOptionWithValue("--list", Configuration.LIST_DEVICES_PROPERTY_NAME, Boolean.TRUE);
        addHelp(Configuration.LIST_DEVICES_PROPERTY_NAME, null,
                "Print the list the connected devices.");

        addOptionWithArg("-x", Configuration.ADD_LAUNCH_ARG_PROPERTY_NAME);
        addOptionWithArg("--launch-arg", Configuration.ADD_LAUNCH_ARG_PROPERTY_NAME);
        addHelp(Configuration.ADD_LAUNCH_ARG_PROPERTY_NAME,
                "-x=my_arg",
                "Pass a value as launch argument, pass this option multiple times to " +
                        "specify multiple values.");

        addOptionWithArg("-e", Configuration.ADD_ENV_VAR_PROPERTY_NAME);
        addOptionWithArg("--env", Configuration.ADD_ENV_VAR_PROPERTY_NAME);
        addHelp(Configuration.ADD_ENV_VAR_PROPERTY_NAME,
                "-e=key=value",
                "Pass a key-value pair as an env variable, pass this option multiple " +
                        "times to specify multiple key-values pairs.");

        addOptionWithArg("-d", Configuration.JDWP_PORT_PROPERTY_NAME);
        addOptionWithArg("--debug", Configuration.JDWP_PORT_PROPERTY_NAME);
        addHelp(Configuration.JDWP_PORT_PROPERTY_NAME,
                "--debug=5005",
                "Start the app with the JDWP debugger on the specified port, and creates a proxy " +
                        "server for it.");

        addOptionWithArg("-o", Configuration.STD_OUT_PROPERTY_NAME);
        addOptionWithArg("--output", Configuration.STD_OUT_PROPERTY_NAME);
        addHelp(Configuration.STD_OUT_PROPERTY_NAME,
                "-o=2541",
                "Set the port for forwarding standard output from the device. If this option is " +
                        "not specified, then the launcher's standard output will be used.");

        addOptionWithArg("-of", Configuration.STD_OUT_FILE_PROPERTY_NAME);
        addOptionWithArg("--output-file", Configuration.STD_OUT_FILE_PROPERTY_NAME);
        addHelp(Configuration.STD_OUT_FILE_PROPERTY_NAME,
                "-of=log.txt",
                "Set the file to which standard output and standard error should be written to.");

        addOptionWithValue("-noact", Configuration.DONT_ACTIVATE_PROPERTY_NAME, Boolean.TRUE);
        addOptionWithValue("--dont-activate", Configuration.DONT_ACTIVATE_PROPERTY_NAME, Boolean.TRUE);
        addHelp(Configuration.DONT_ACTIVATE_PROPERTY_NAME,
                "--dont-activate",
                "Do not activate (aka. bring to foreground) the simulator after it launched the app.");

        addOptionWithValue("-wdeb", Configuration.WAIT_FOR_DEBUGGER_PROPERTY_NAME, Boolean.TRUE);
        addOptionWithValue("--wait-for-debugger", Configuration.WAIT_FOR_DEBUGGER_PROPERTY_NAME, Boolean.TRUE);
        addHelp(Configuration.WAIT_FOR_DEBUGGER_PROPERTY_NAME,
                "-wdeb",
                "Launch the app, but don't start it, wait for a debugger to attach.");

        addOptionWithValue("-ttv", Configuration.TARGET_PLATFORM_TVOS_PROPERTY_NAME, Boolean.TRUE);
        addOptionWithValue("--target-tvos", Configuration.TARGET_PLATFORM_TVOS_PROPERTY_NAME, Boolean.TRUE);
        addHelp(Configuration.TARGET_PLATFORM_TVOS_PROPERTY_NAME,
                "-ttv",
                "Set the target platform to tvOS. When not specified, iOS is implied.");

        addOptionWithValue("-twatch", Configuration.TARGET_PLATFORM_WATCHOS_PROPERTY_NAME, Boolean.TRUE);
        addOptionWithValue("--target-watchos", Configuration.TARGET_PLATFORM_WATCHOS_PROPERTY_NAME, Boolean.TRUE);
        addHelp(Configuration.TARGET_PLATFORM_WATCHOS_PROPERTY_NAME,
                "-twatch",
                "Set the target platform to watchOS. When not specified, iOS is implied. This " +
                        "argument will be ignored if -ttv is set");
    }
}
