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
import org.moe.natj.general.ptr.IntPtr;
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.objc.Class;
import org.moe.natj.objc.ObjCObject;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.IsOptional;
import org.moe.natj.objc.ann.ObjCBlock;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;
import mac.NSObject;
import mac.devtools.xcode6.protocol.DVTInvalidation;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class DVTiPhoneSimulatorMessenger extends NSObject implements
		DVTInvalidation {
	static {
		NatJ.register();
	}

	@Generated
	protected DVTiPhoneSimulatorMessenger(Pointer peer) {
		super(peer);
	}

	@Generated
	@Owned
	@Selector("alloc")
	public static native DVTiPhoneSimulatorMessenger alloc();

	@Generated
	@Selector("backgroundAllApps:")
	public native void backgroundAllApps(int arg1);

	@Generated
	@Selector("clearAllMessageHandlers")
	public native void clearAllMessageHandlers();

	@Generated
	@Selector("connectToServiceWithSessionOnLaunch:simulatorPID:error:")
	public native boolean connectToServiceWithSessionOnLaunchSimulatorPIDError(
			boolean arg1, IntPtr arg2, Ptr<ObjCObject> arg3);

	@Generated
	@Selector("creationBacktrace")
	public native IntPtr creationBacktrace();

	@Generated
	@Selector("debugDescription")
	public native String debugDescription();

	@Generated
	@Selector("description")
	public native String description();

	@Generated
	@Selector("didReceiveSimulatorReadyNote:")
	public native void didReceiveSimulatorReadyNote(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("didReceiveSimulatorRunningNote:")
	public native void didReceiveSimulatorRunningNote(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("disconnectFromService")
	public native void disconnectFromService();

	@Generated
	@Selector("doFetchEventForPID:")
	public native void doFetchEventForPID(int arg1);

	@Generated
	@Selector("doUbiquityFetchEvent")
	public native void doUbiquityFetchEvent();

	@Generated
	@Selector("endSimulatorSessionWithPID:")
	public native void endSimulatorSessionWithPID(int arg1);

	@Generated
	@Selector("hash")
	public native long hash();

	@Generated
	@Selector("initWithSession:")
	public native DVTiPhoneSimulatorMessenger initWithSession(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("initialize")
	public static native void initialize();

	@Generated
	@Selector("installApplicationWithConfig:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object installApplicationWithConfig(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@IsOptional
	@Selector("invalidate")
	public native void invalidate();

	@Generated
	@Selector("invalidationBacktrace")
	public native IntPtr invalidationBacktrace();

	@Generated
	@Selector("isValid")
	public native boolean isValid();

	@Generated
	@Selector("launchApplicationWithConfig:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object launchApplicationWithConfig(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("messengerForSession:")
	public static native DVTiPhoneSimulatorMessenger messengerForSession(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("primitiveInvalidate")
	public native void primitiveInvalidate();

	@Generated
	@Selector("session")
	public native DTiPhoneSimulatorSession session();

	@Generated
	@Selector("setCreationBacktrace:")
	public native void setCreationBacktrace(IntPtr value);

	@Generated
	@Selector("spawnToolWithConfig:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object spawnToolWithConfig(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("startSessionWithConfig:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object startSessionWithConfig(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("startSimulatingLocationWithLatitude:longitute:")
	public native void startSimulatingLocationWithLatitudeLongitute(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("startSimulatorSessionWithRequestInfo:")
	public native void startSimulatorSessionWithRequestInfo(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("startSimulatorToolSessionWithParameters:")
	public native void startSimulatorToolSessionWithParameters(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("stopSimulatingLocation")
	public native void stopSimulatingLocation();

	@Generated
	@Selector("superclass")
	public native Class superclass();

	@Generated
	@Selector("waitPID:withAppPIDExitedMessagedHandler:")
	public native void waitPIDWithAppPIDExitedMessagedHandler(
			int arg1,
			@ObjCBlock(name = "call_waitPIDWithAppPIDExitedMessagedHandler") Block_waitPIDWithAppPIDExitedMessagedHandler arg2);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_waitPIDWithAppPIDExitedMessagedHandler {
		@Generated
		public void call_waitPIDWithAppPIDExitedMessagedHandler();
	}

	@Generated
	@Selector("init")
	public native DVTiPhoneSimulatorMessenger init();
}
