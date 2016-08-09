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
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;
import mac.NSObject;
import mac.devtools.xcode6.protocol.DVTInvalidation;
import mac.foundation.NSTimer;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class DTiPhoneSimulatorSession extends NSObject implements
		DVTInvalidation {
	static {
		NatJ.register();
	}

	@Generated
	protected DTiPhoneSimulatorSession(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("_callDelegateResponseFromSessionStartedWithPID:andError:")
	public native void _callDelegateResponseFromSessionStartedWithPIDAndError(
			int arg1, @Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("_endSimulatorSession")
	public native void _endSimulatorSession();

	@Generated
	@Selector("_handleSessionEndedWithError:")
	public native void _handleSessionEndedWithError(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("_invalidConfigError")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _invalidConfigError();

	@Generated
	@Selector("_sessionStartRequestInfoFromConfig:withError:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _sessionStartRequestInfoFromConfigWithError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("_setUpSimulatorMessengerWithConfig:error:")
	public native boolean _setUpSimulatorMessengerWithConfigError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("_startApplicationSessionInSimulatorWithError:")
	public native boolean _startApplicationSessionInSimulatorWithError(
			Ptr<ObjCObject> arg1);

	@Generated
	@Selector("_startBasicSessionInSimulatorWithError:")
	public native boolean _startBasicSessionInSimulatorWithError(
			Ptr<ObjCObject> arg1);

	@Generated
	@Selector("_startSessionInSimulatorWithError:")
	public native boolean _startSessionInSimulatorWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("_startToolSessionInSimulatorWithError:")
	public native boolean _startToolSessionInSimulatorWithError(
			Ptr<ObjCObject> arg1);

	@Generated
	@Selector("_timeoutElapsed:")
	public native void _timeoutElapsed(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Owned
	@Selector("alloc")
	public static native DTiPhoneSimulatorSession alloc();

	@Generated
	@Selector("attachedToTargetWithConfig:error:")
	public native boolean attachedToTargetWithConfigError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("backgroundAllApps:")
	public native void backgroundAllApps(int arg1);

	@Generated
	@Selector("creationBacktrace")
	public native IntPtr creationBacktrace();

	@Generated
	@Selector("debugDescription")
	public native String debugDescription();

	@Generated
	@Selector("delegate")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object delegate();

	@Generated
	@Selector("description")
	public native String description();

	@Generated
	@Selector("doFetchEventForPID:")
	public native void doFetchEventForPID(int arg1);

	@Generated
	@Selector("doUbiquityFetchEvent")
	public native void doUbiquityFetchEvent();

	@Generated
	@Selector("hash")
	public native long hash();

	@Generated
	@Selector("init")
	public native DTiPhoneSimulatorSession init();

	@Generated
	@Selector("initialize")
	public static native void initialize();

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
	@Selector("messenger")
	public native DVTiPhoneSimulatorMessenger messenger();

	@Generated
	@Selector("primitiveInvalidate")
	public native void primitiveInvalidate();

	@Generated
	@Selector("requestEndWithTimeout:")
	public native void requestEndWithTimeout(double arg1);

	@Generated
	@Selector("requestStartWithConfig:timeout:error:")
	public native boolean requestStartWithConfigTimeoutError(
			@Mapped(ObjCObjectMapper.class) Object arg1, double arg2,
			Ptr<ObjCObject> arg3);

	@Generated
	@Selector("sessionConfig")
	public native DTiPhoneSimulatorSessionConfig sessionConfig();

	@Generated
	@Selector("sessionLifecycleProgress")
	public native long sessionLifecycleProgress();

	@Generated
	@Selector("setCreationBacktrace:")
	public native void setCreationBacktrace(IntPtr value);

	@Generated
	@Selector("setDelegate:")
	public native void setDelegate(@Mapped(ObjCObjectMapper.class) Object value);

	@Generated
	@Selector("setMessenger:")
	public native void setMessenger(DVTiPhoneSimulatorMessenger value);

	@Generated
	@Selector("setSessionConfig:")
	public native void setSessionConfig(DTiPhoneSimulatorSessionConfig value);

	@Generated
	@Selector("setSessionLifecycleProgress:")
	public native void setSessionLifecycleProgress(long value);

	@Generated
	@Selector("setSimulatedAppPath:")
	public native void setSimulatedAppPath(String value);

	@Generated
	@Selector("setSimulatedApplicationPID:")
	public native void setSimulatedApplicationPID(int value);

	@Generated
	@Selector("setSimulatorPID:")
	public native void setSimulatorPID(int value);

	@Generated
	@Selector("setTimeoutTimer:")
	public native void setTimeoutTimer(NSTimer value);

	@Generated
	@Selector("simulateLocationWithLatitude:longitude:")
	public native void simulateLocationWithLatitudeLongitude(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("simulatedAppPath")
	public native String simulatedAppPath();

	@Generated
	@Selector("simulatedApplicationPID")
	public native int simulatedApplicationPID();

	@Generated
	@Selector("simulatorPID")
	public native int simulatorPID();

	@Generated
	@Selector("stopLocationSimulation")
	public native void stopLocationSimulation();

	@Generated
	@Selector("superclass")
	public native Class superclass();

	@Generated
	@Selector("timeoutTimer")
	public native NSTimer timeoutTimer();

	@Generated
	@Selector("uuid")
	public native String uuid();
}
