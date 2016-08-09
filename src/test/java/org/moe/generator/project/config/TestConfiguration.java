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

package org.moe.generator.project.config;

import org.moe.common.Port;
import org.moe.common.configuration.AbstractConfiguration;
import org.moe.common.configuration.TestAbstractConfiguration;
import org.moe.ios.simulator.launcher.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Configuration tests.
 */
public class TestConfiguration extends TestAbstractConfiguration {

    private Configuration configuration;

    @Before
    public void setup() {
        configuration = new Configuration();
        setAbstractConfiguration(configuration);
    }

    @Test
    public void testDeviceUDID() {
        Assert.assertNotNull(configuration);
        Assert.assertNull(configuration.getDeviceUDID());

        configuration.setDeviceUDID(null);
        Assert.assertNull(configuration.getDeviceUDID());

        String temp = "temp";
        configuration.setDeviceUDID(temp);
        Assert.assertEquals(temp, configuration.getDeviceUDID());

        testProperty(Configuration.DEVICE_UDID_PROPERTY_NAME, temp, "temp2");
    }

    @Test
    public void testApplicationPath() {
        Assert.assertNotNull(configuration);
        Assert.assertNull(configuration.getApplicationPath());

        configuration.setApplicationPath(null);
        Assert.assertNull(configuration.getApplicationPath());

        File temp = new File("temp");
        configuration.setApplicationPath(temp);
        Assert.assertEquals(temp, configuration.getApplicationPath());

        testProperty(Configuration.APPLICATION_PATH_PROPERTY_NAME, temp, new File("temp2"));
    }

    @Test
    public void testListDevices() {
        Assert.assertNotNull(configuration);
        Assert.assertFalse(configuration.getListDevices());

        configuration.setListDevices(true);
        Assert.assertTrue(configuration.getListDevices());

        configuration.setListDevices(false);
        Assert.assertFalse(configuration.getListDevices());

        Boolean temp = Boolean.TRUE;
        configuration.setListDevices(temp);
        Assert.assertEquals(temp, configuration.getListDevices());

        testProperty(Configuration.LIST_DEVICES_PROPERTY_NAME, temp, Boolean.FALSE);
    }

    @Test
    public void testAddLaunchArg() {
        Assert.assertNotNull(configuration);
        Assert.assertEquals(0, configuration.getLaunchArgs().size());

        configuration.addLaunchArg("value");
        Assert.assertEquals(1, configuration.getLaunchArgs().size());
    }

    @Test
    public void testAddEnvVar() {
        Assert.assertNotNull(configuration);
        Assert.assertEquals(0, configuration.getEnvVars().size());

        configuration.addEnvVar("key", "value");
        Assert.assertEquals(1, configuration.getEnvVars().size());
    }

    @Test
    public void testJdwpPort() {
        Assert.assertNotNull(configuration);
        Assert.assertNull(configuration.getJdwpPort());

        configuration.setJdwpPort(null);
        Assert.assertNull(configuration.getJdwpPort());

        Port temp = new Port((short) 123);
        configuration.setJdwpPort(temp);
        Assert.assertEquals(temp, configuration.getJdwpPort());

        testProperty(Configuration.JDWP_PORT_PROPERTY_NAME, temp, new Port((short) 456));
    }

    @Test
    public void testStdOut() {
        Assert.assertNotNull(configuration);
        Assert.assertNull(configuration.getStdOutPort());

        configuration.setStdOutPort(null);
        Assert.assertNull(configuration.getStdOutPort());

        Port temp = new Port((short) 123);
        configuration.setStdOutPort(temp);
        Assert.assertEquals(temp, configuration.getStdOutPort());

        testProperty(Configuration.STD_OUT_PROPERTY_NAME, temp, new Port((short) 456));
    }

    @Test
    public void testStdOutFile() {
        Assert.assertNotNull(configuration);
        Assert.assertNull(configuration.getStdOutFile());

        configuration.setStdOutFile(null);
        Assert.assertNull(configuration.getStdOutFile());

        File temp = new File("temp");
        configuration.setStdOutFile(temp);
        Assert.assertEquals(temp, configuration.getStdOutFile());

        testProperty(Configuration.STD_OUT_FILE_PROPERTY_NAME, temp, new File("temp2"));
    }

    @Test
    public void testDontActivate() {
        Assert.assertNotNull(configuration);
        Assert.assertFalse(configuration.getDontActivate());

        configuration.setDontActivate(true);
        Assert.assertTrue(configuration.getDontActivate());

        configuration.setDontActivate(false);
        Assert.assertFalse(configuration.getDontActivate());

        Boolean temp = Boolean.TRUE;
        configuration.setDontActivate(temp);
        Assert.assertEquals(temp, configuration.getDontActivate());

        testProperty(Configuration.DONT_ACTIVATE_PROPERTY_NAME, temp, Boolean.FALSE);
    }

    @Test
    public void testWaitForDebugger() {
        Assert.assertNotNull(configuration);
        Assert.assertFalse(configuration.getWaitForDebugger());

        configuration.setWaitForDebugger(true);
        Assert.assertTrue(configuration.getWaitForDebugger());

        configuration.setWaitForDebugger(false);
        Assert.assertFalse(configuration.getWaitForDebugger());

        Boolean temp = Boolean.TRUE;
        configuration.setWaitForDebugger(temp);
        Assert.assertEquals(temp, configuration.getWaitForDebugger());

        testProperty(Configuration.WAIT_FOR_DEBUGGER_PROPERTY_NAME, temp, Boolean.FALSE);
    }

    @Test
    public void testTargetPlatformTvOS() {
        Assert.assertNotNull(configuration);
        Assert.assertFalse(configuration.getTargetPlatformTvOS());

        configuration.setTargetPlatformTvOS(true);
        Assert.assertTrue(configuration.getTargetPlatformTvOS());

        configuration.setTargetPlatformTvOS(false);
        Assert.assertFalse(configuration.getTargetPlatformTvOS());

        Boolean temp = Boolean.TRUE;
        configuration.setTargetPlatformTvOS(temp);
        Assert.assertEquals(temp, configuration.getTargetPlatformTvOS());

        testProperty(Configuration.TARGET_PLATFORM_TVOS_PROPERTY_NAME, temp, Boolean.FALSE);
    }

    @Test
    public void testTargetPlatformWatchOS() {
        Assert.assertNotNull(configuration);
        Assert.assertFalse(configuration.getTargetPlatformWatchOS());

        configuration.setTargetPlatformWatchOS(true);
        Assert.assertTrue(configuration.getTargetPlatformWatchOS());

        configuration.setTargetPlatformWatchOS(false);
        Assert.assertFalse(configuration.getTargetPlatformWatchOS());

        Boolean temp = Boolean.TRUE;
        configuration.setTargetPlatformWatchOS(temp);
        Assert.assertEquals(temp, configuration.getTargetPlatformWatchOS());

        testProperty(Configuration.TARGET_PLATFORM_WATCHOS_PROPERTY_NAME, temp, Boolean.FALSE);
    }

    @Test
    public void testValidation() {
        configuration.setDeviceUDID("");
        testValidate(Configuration.DEVICE_UDID_PROPERTY_NAME, AbstractConfiguration.PROPERTY_IS_EMPTY_ERROR);
        configuration.setDeviceUDID(null);

        configuration.setApplicationPath(null);
        testValidate(Configuration.APPLICATION_PATH_PROPERTY_NAME, AbstractConfiguration.PROPERTY_NOT_DEFINED_ERROR);
        configuration.setApplicationPath(new File("/nonexistent-651FA651S6F5A1S6df.app"));
        testValidate(Configuration.APPLICATION_PATH_PROPERTY_NAME, AbstractConfiguration.PROPERTY_DIRECTORY_DOESNT_EXIST_ERROR);
        configuration.setApplicationPath(null);

        configuration.setListDevices(true);

        testValidate(null, null);
    }
}
