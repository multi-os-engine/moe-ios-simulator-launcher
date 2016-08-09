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

import org.moe.ios.simulator.launcher.Main;
import mac.devtools.xcode7.DVTPlatform;
import mac.foundation.NSBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * Developer Tools utility for Xcode setup.
 */
public class DevToolsUtil {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DevToolsUtil.class);

    private String xcodePath = Main.getXcodePath();

    Set<String> loadedBundles = Collections.synchronizedSet(new HashSet<String>());

    private List<String> runExec(String... cmd) {
        ProcessBuilder ps = new ProcessBuilder(cmd);
        ps.redirectErrorStream(true);
        ArrayList<String> lines = new ArrayList<String>();
        try {
            Process pr = ps.start();
            InputStream is = pr.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    lines.add(line);
                }
                try {
                    pr.waitFor();
                } catch (InterruptedException ignore) {

                }
            } finally {
                is.close();
                in.close();
            }
        } catch (IOException ignore) {
            //ignore
        }
        return lines;
    }

    private DevToolsUtil() {
        try {
            NSBundle.bundleWithPath(new File(xcodePath, "../SharedFrameworks/DVTSourceControl.framework").getCanonicalPath()).load_objc();
            NSBundle.bundleWithPath(new File(xcodePath, "../SharedFrameworks/DVTFoundation.framework").getCanonicalPath()).load_objc();
            NSBundle.bundleWithPath(new File(xcodePath, "../Frameworks/IDEFoundation.framework").getCanonicalPath()).load_objc();
            NSBundle.bundleWithPath(new File(xcodePath, "../PlugIns/Xcode3Core.ideplugin/Contents/Frameworks/DevToolsFoundation.framework").getCanonicalPath()).load_objc();
            NSBundle.bundleWithPath(new File(xcodePath, "../PlugIns/Xcode3Core.ideplugin/Contents/Frameworks/DevToolsSupport.framework").getCanonicalPath()).load_objc();
            NSBundle.bundleWithPath(new File(xcodePath, "../PlugIns/Xcode3Core.ideplugin/Contents/Frameworks/DevToolsCore.framework").getCanonicalPath()).load_objc();
            NSBundle.bundleWithPath(new File(xcodePath, "../PlugIns/IDEiOSSupportCore.ideplugin").getCanonicalPath()).load_objc();

            if (!DVTPlatform.loadAllPlatformsReturningError(null)) {
                throw new RuntimeException("Failed to load all platforms");
            }
        } catch (IOException e) {
            LOG.error("Could not load libraries", e);
        }
    }

    private static DevToolsUtil get() {
        return Holder.INSTANCE;
    }

    public static void init() {
        get();
    }

    private static class Holder {
        public static final DevToolsUtil INSTANCE = new DevToolsUtil();
    }

}
