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

package mac.devtools.xcode7;

import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.*;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.objc.ObjCObject;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCBlock;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;
import mac.foundation.NSError;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class DVTSimulatorApplication extends ObjCObject {
    static {
        NatJ.register();
    }

    @Generated
    protected DVTSimulatorApplication(Pointer peer) {
        super(peer);
    }

    @Generated
    @Selector("_defaultSimulator")
    @MappedReturn(ObjCObjectMapper.class)
    public static native DVTSimulatorApplication _defaultSimulator();

    @Generated
    @Selector("_sendNotificationWithName:andUserInfo:")
    public native void _sendNotificationWithNameAndUserInfo(@Mapped(ObjCObjectMapper.class) Object arg1,
                                                            @Mapped(ObjCObjectMapper.class) Object arg2);

    @Generated
    @Selector("_simulatorApplicationForWatches")
    @MappedReturn(ObjCObjectMapper.class)
    public static native Object _simulatorApplicationForWatches();

    @Generated
    @Selector("addObserverForReadyNotification:")
    @MappedReturn(ObjCObjectMapper.class)
    public native Object addObserverForReadyNotification(@ObjCBlock(name = "call_addObserverForReadyNotification") Block_addObserverForReadyNotification arg1);

    static public interface Block_addObserverForReadyNotification {
        @Generated
        public void call_addObserverForReadyNotification();
    }

    @Generated
    @Selector("allSimulatorApplications")
    @MappedReturn(ObjCObjectMapper.class)
    public static native Object allSimulatorApplications();

    @Generated
    @Owned
    @Selector("alloc")
    public static native DVTSimulatorApplication alloc();

    @Generated
    @Selector("initWithPath:")
    public native DVTSimulatorApplication initWithPath(@Mapped(ObjCObjectMapper.class) Object arg1);

    @Generated
    @Selector("launchWithError:")
    public native int launchWithError(Ptr<NSError> arg1);

    @Generated
    @Selector("launchWithError:andReadyCallback:")
    public native int launchWithErrorAndReadyCallback(Ptr<NSError> arg1,
                                                      @ObjCBlock(name = "call_launchWithErrorAndReadyCallback") Block_launchWithErrorAndReadyCallback callback);

    static public interface Block_launchWithErrorAndReadyCallback {
        @Generated
        public void call_launchWithErrorAndReadyCallback();
    }

    @Generated
    @Selector("sendApplicationEventNotificationWithUserInfo:")
    public native void sendApplicationEventNotificationWithUserInfo(@Mapped(ObjCObjectMapper.class) Object arg1);

    @Generated
    @Selector("sendRequestCloudSyncNotification")
    public native void sendRequestCloudSyncNotification();

    @Generated
    @Selector("sendSimulateLocationNotificationWithLatitude:longitude:")
    public native void sendSimulateLocationNotificationWithLatitudeLongitude(
            @Mapped(ObjCObjectMapper.class) Object arg1, @Mapped(ObjCObjectMapper.class) Object arg2);

    @Generated
    @Selector("sendStartSessionNotificationWithUserInfo:")
    public native void sendStartSessionNotificationWithUserInfo(@Mapped(ObjCObjectMapper.class) Object arg1);

    @Generated
    @Selector("sendStopSimulateLocationNotification")
    public native void sendStopSimulateLocationNotification();

    @Generated
    @Selector("simulatorApplicationForDevice:")
    public static native DVTSimulatorApplication simulatorApplicationForDevice(
            @Mapped(ObjCObjectMapper.class) Object arg1);

    @Generated
    @Selector("simulatorApplicationForPlatform:")
    public static native DVTSimulatorApplication simulatorApplicationForPlatform(
            @Mapped(ObjCObjectMapper.class) Object arg1);

    @Generated
    @Selector("simulatorApplicationWithBundleIdentifier:")
    public static native DVTSimulatorApplication simulatorApplicationWithBundleIdentifier(
            @Mapped(ObjCObjectMapper.class) Object arg1);
}
