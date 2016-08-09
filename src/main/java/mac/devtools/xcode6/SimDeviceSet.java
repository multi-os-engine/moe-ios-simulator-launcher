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

package mac.devtools.xcode6;


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
import mac.NSObject;
import mac.devtools.xcode6.protocol.SimDeviceNotifier;
import mac.foundation.NSArray;
import mac.foundation.NSDictionary;
import mac.foundation.NSError;
import mac.foundation.NSMutableDictionary;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SimDeviceSet extends NSObject implements SimDeviceNotifier {
	static {
		NatJ.register();
	}

	@Generated
	protected SimDeviceSet(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("_devicesByUDID")
	public native NSMutableDictionary _devicesByUDID();

	@Generated
	@Selector("addDevice:")
	public native void addDevice(SimDevice arg1);

	@Generated
	@Selector("addDeviceAsync:")
	public native void addDeviceAsync(
			SimDevice arg1);

	@Generated
	@Owned
	@Selector("alloc")
	public static native SimDeviceSet alloc();

	@Generated
	@Selector("availableDevices")
	public native NSArray availableDevices();

	@Generated
	@Selector("connectionManager")
	public native SimServiceConnectionManager connectionManager();

	@Generated
	@Selector("createDeviceAsyncWithType:runtime:name:completionHandler:")
	public native void createDeviceAsyncWithTypeRuntimeNameCompletionHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3,
			@ObjCBlock(name = "call_createDeviceAsyncWithTypeRuntimeNameCompletionHandler") Block_createDeviceAsyncWithTypeRuntimeNameCompletionHandler arg4);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_createDeviceAsyncWithTypeRuntimeNameCompletionHandler {
		@Generated
		public void call_createDeviceAsyncWithTypeRuntimeNameCompletionHandler();
	}

	@Generated
	@Selector("createDeviceWithType:runtime:name:error:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object createDeviceWithTypeRuntimeNameError(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3, Ptr<ObjCObject> arg4);

	@Generated
	@Selector("defaultCreatedPlistPath")
	public native String defaultCreatedPlistPath();

	@Generated
	@Selector("defaultSet")
	public static native SimDeviceSet defaultSet();

	@Generated
	@Selector("defaultSetPath")
	public static native String defaultSetPath();

	@Generated
	@Selector("deleteDevice:error:")
	public native boolean deleteDeviceError(
			SimDevice arg1, Ptr<NSError> arg2);

	@Generated
	@Selector("deleteDeviceAsync:completionHandler:")
	public native void deleteDeviceAsyncCompletionHandler(
			SimDevice arg1,
			@ObjCBlock(name = "call_deleteDeviceAsyncCompletionHandler") Block_deleteDeviceAsyncCompletionHandler arg2);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_deleteDeviceAsyncCompletionHandler {
		@Generated
		public void call_deleteDeviceAsyncCompletionHandler();
	}

	@Generated
	@Selector("devices")
	public native NSArray devices();

	@Generated
	@Selector("devicesByUDID")
	public native NSDictionary devicesByUDID();

	@Generated
	@Selector("devicesNotificationRegIDs")
	public native NSMutableDictionary devicesNotificationRegIDs();

	@Generated
	@Selector("devicesQueue")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object devicesQueue();

	@Generated
	@Selector("dvt_registerNotificationHandler:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_registerNotificationHandler(
			@ObjCBlock(name = "call_dvt_registerNotificationHandler") Block_dvt_registerNotificationHandler arg1);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_dvt_registerNotificationHandler {
		@Generated
		public void call_dvt_registerNotificationHandler();
	}

	@Generated
	@Selector("dvt_registerNotificationHandlerOnQueue:handler:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_registerNotificationHandlerOnQueueHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_dvt_registerNotificationHandlerOnQueueHandler") Block_dvt_registerNotificationHandlerOnQueueHandler arg2);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_dvt_registerNotificationHandlerOnQueueHandler {
		@Generated
		public void call_dvt_registerNotificationHandlerOnQueueHandler();
	}

	@Generated
	@Selector("handleXPCNotification:")
	public native void handleXPCNotification(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("handleXPCNotificationDeviceAdded:")
	public native void handleXPCNotificationDeviceAdded(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("handleXPCNotificationDeviceRemoved:")
	public native void handleXPCNotificationDeviceRemoved(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("handleXPCRequest:peer:")
	public native void handleXPCRequestPeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestCreateDevice:peer:")
	public native void handleXPCRequestCreateDevicePeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestDeleteDevice:peer:device:")
	public native void handleXPCRequestDeleteDevicePeerDevice(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3);

	@Generated
	@Selector("initWithSetPath:")
	public native SimDeviceSet initWithSetPath(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("notificationManager")
	public native SimDeviceNotificationManager notificationManager();

	@Generated
	@Selector("registerNotificationHandler:")
	public native long registerNotificationHandler(
			@ObjCBlock(name = "call_registerNotificationHandler") SimDeviceNotifier.Block_registerNotificationHandler arg1);

	@Generated
	@Selector("registerNotificationHandlerOnQueue:handler:")
	public native long registerNotificationHandlerOnQueueHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_registerNotificationHandlerOnQueueHandler") SimDeviceNotifier.Block_registerNotificationHandlerOnQueueHandler arg2);

	@Generated
	@Selector("removeDeviceAsync:")
	public native void removeDeviceAsync(
			SimDevice arg1);

	@Generated
	@Selector("resubscribeAllToNotifications")
	public static native void resubscribeAllToNotifications();

	@Generated
	@Selector("setConnectionManager:")
	public native void setConnectionManager(SimServiceConnectionManager value);

	@Generated
	@Selector("setDevicesNotificationRegIDs:")
	public native void setDevicesNotificationRegIDs(NSMutableDictionary value);

	@Generated
	@Selector("setDevicesQueue:")
	public native void setDevicesQueue(
			@Mapped(ObjCObjectMapper.class) Object value);

	@Generated
	@Selector("setForSetPath:")
	public static native SimDeviceSet setForSetPath(
			String arg1);

	@Generated
	@Selector("setNotificationManager:")
	public native void setNotificationManager(SimDeviceNotificationManager value);

	@Generated
	@Selector("setPath")
	public native String setPath();

	@Generated
	@Selector("setSetPath:")
	public native void setSetPath(String value);

	@Generated
	@Selector("set_devicesByUDID:")
	public native void set_devicesByUDID(NSMutableDictionary value);

	@Generated
	@Selector("subscribeToNotificationsWithError:")
	public native boolean subscribeToNotificationsWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("unregisterNotificationHandler:error:")
	public native boolean unregisterNotificationHandlerError(long arg1,
			Ptr<ObjCObject> arg2);

	@Generated
	@Selector("updateDefaultDevices")
	public native void updateDefaultDevices();

	@Generated
	@Selector("init")
	public native SimDeviceSet init();
}
