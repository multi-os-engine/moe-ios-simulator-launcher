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

import mac.devtools.xcode6.DVTPlatform;
import mac.foundation.NSBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Developer Tools utility for Xcode setup.
 */
public class DevToolsUtil {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DevToolsUtil.class);

    private DevToolsUtil() {
        String xcodePath = getXcodePath();
        loadBundle(xcodePath, "../SharedFrameworks/DVTFoundation.framework");
        loadBundle(xcodePath, "../OtherFrameworks/DevToolsFoundation.framework");
        loadBundle(xcodePath, "Library/PrivateFrameworks/CoreSimulator.framework");
        if (!DVTPlatform.loadAllPlatformsReturningError(null)) {
            throw new RuntimeException("Failed to load all platforms");
        }
        loadBundle(xcodePath, "../SharedFrameworks/DVTiPhoneSimulatorRemoteClient.framework");
    }

    private static DevToolsUtil get() {
        return Holder.INSTANCE;
    }

    public static void init() {
        get();
    }

    private NSBundle loadBundle(String xcodePath, String subPath) {
        File file = new File(xcodePath, subPath);

        NSBundle bundle = NSBundle.bundleWithPath(file.getAbsolutePath());
        if (!bundle.load_objc()) {
            throw new RuntimeException("Failed to load bundle " + file.getAbsolutePath());
        }

        LOG.debug("Loaded " + file.getAbsolutePath());
        return bundle;
    }

    private String getXcodePath() {
        String path = System.getenv("DEVELOPER_DIR");
        if (path != null && path.length() > 0) {
            return path;
        }

        ProcessBuilder pb = new ProcessBuilder("/usr/bin/xcode-select", "-print-path");
        Process p = null;
        try {
            p = pb.start();
            InputStream is = p.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(is));

            try {
                path = input.readLine();
                p.waitFor();
            } catch (Exception ex) {
                throw new RuntimeException("Failed to get Xcode Developer path");
            } finally {
                is.close();
                input.close();
            }
        } catch (IOException ignore) {
            //Ignore
        }
        if (p == null || p.exitValue() != 0 || path == null || path.length() == 0) {
            throw new RuntimeException("Failed to get Xcode Developer path");
        }
        return path;
    }

    private static class Holder {
        public static final DevToolsUtil INSTANCE = new DevToolsUtil();
    }

}
