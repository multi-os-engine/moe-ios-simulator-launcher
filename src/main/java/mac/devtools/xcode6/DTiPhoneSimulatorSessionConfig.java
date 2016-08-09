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
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;
import mac.NSObject;
import mac.foundation.NSArray;
import mac.foundation.NSDictionary;
import mac.foundation.NSFileHandle;
import mac.foundation.NSNumber;
import mac.foundation.protocol.NSCopying;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class DTiPhoneSimulatorSessionConfig extends NSObject implements
		NSCopying {
	static {
		NatJ.register();
	}

	@Generated
	protected DTiPhoneSimulatorSessionConfig(Pointer peer) {
		super(peer);
	}

	@Generated
	@Owned
	@Selector("alloc")
	public static native DTiPhoneSimulatorSessionConfig alloc();

	@Generated
	@Selector("applicationToSimulateOnStart")
	public native DTiPhoneSimulatorApplicationSpecifier applicationToSimulateOnStart();

	@Generated
	@Owned
	@Selector("copyWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object copyWithZone(VoidPtr arg1);

	@Generated
	@Selector("device")
	public native SimDevice device();

	@Generated
	@Selector("displayNameForDeviceFamily:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object displayNameForDeviceFamily(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("init")
	public native DTiPhoneSimulatorSessionConfig init();

	@Generated
	@Selector("launchForBackgroundFetch")
	public native boolean launchForBackgroundFetch();

	@Generated
	@Selector("localizedClientName")
	public native String localizedClientName();

	@Generated
	@Selector("pid")
	public native NSNumber pid();

	@Generated
	@Selector("runtime")
	public native SimRuntime runtime();

	@Generated
	@Selector("setApplicationToSimulateOnStart:")
	public native void setApplicationToSimulateOnStart(DTiPhoneSimulatorApplicationSpecifier value);

	@Generated
	@Selector("setDevice:")
	public native void setDevice(SimDevice value);

	@Generated
	@Selector("setLaunchForBackgroundFetch:")
	public native void setLaunchForBackgroundFetch(boolean value);

	@Generated
	@Selector("setLocalizedClientName:")
	public native void setLocalizedClientName(String value);

	@Generated
	@Selector("setPid:")
	public native void setPid(NSNumber value);

	@Generated
	@Selector("setRuntime:")
	public native void setRuntime(SimRuntime value);

	@Generated
	@Selector("setShouldInstallApplicationToSimulate:")
	public native void setShouldInstallApplicationToSimulate(boolean value);

	@Generated
	@Selector("setSimulatedApplicationLaunchArgs:")
	public native void setSimulatedApplicationLaunchArgs(NSArray value);

	@Generated
	@Selector("setSimulatedApplicationLaunchEnvironment:")
	public native void setSimulatedApplicationLaunchEnvironment(
			NSDictionary value);

	@Generated
	@Selector("setSimulatedApplicationShouldWaitForDebugger:")
	public native void setSimulatedApplicationShouldWaitForDebugger(
			boolean value);

	@Generated
	@Selector("setSimulatedApplicationStdErrPath:")
	public native void setSimulatedApplicationStdErrPath(String value);

	@Generated
	@Selector("setSimulatedApplicationStdOutPath:")
	public native void setSimulatedApplicationStdOutPath(String value);

	@Generated
	@Selector("setSimulatedArchitecture:")
	public native void setSimulatedArchitecture(String value);

	@Generated
	@Selector("setSimulatedDeviceFamily:")
	public native void setSimulatedDeviceFamily(NSNumber value);

	@Generated
	@Selector("setSimulatedDeviceInfoName:")
	public native void setSimulatedDeviceInfoName(String value);

	@Generated
	@Selector("setSimulatedDisplayHeight:")
	public native void setSimulatedDisplayHeight(NSNumber value);

	@Generated
	@Selector("setSimulatedDisplayScale:")
	public native void setSimulatedDisplayScale(NSNumber value);

	@Generated
	@Selector("setSimulatedSystemRoot:")
	public native void setSimulatedSystemRoot(DTiPhoneSimulatorSystemRoot value);

	@Generated
	@Selector("setStderrFileHandle:")
	public native void setStderrFileHandle(NSFileHandle value);

	@Generated
	@Selector("setStdinFileHandle:")
	public native void setStdinFileHandle(NSFileHandle value);

	@Generated
	@Selector("setStdoutFileHandle:")
	public native void setStdoutFileHandle(NSFileHandle value);

	@Generated
	@Selector("shouldInstallApplicationToSimulate")
	public native boolean shouldInstallApplicationToSimulate();

	@Generated
	@Selector("simulatedApplicationLaunchArgs")
	public native NSArray simulatedApplicationLaunchArgs();

	@Generated
	@Selector("simulatedApplicationLaunchEnvironment")
	public native NSDictionary simulatedApplicationLaunchEnvironment();

	@Generated
	@Selector("simulatedApplicationShouldWaitForDebugger")
	public native boolean simulatedApplicationShouldWaitForDebugger();

	@Generated
	@Selector("simulatedApplicationStdErrPath")
	public native String simulatedApplicationStdErrPath();

	@Generated
	@Selector("simulatedApplicationStdOutPath")
	public native String simulatedApplicationStdOutPath();

	@Generated
	@Selector("simulatedArchitecture")
	public native String simulatedArchitecture();

	@Generated
	@Selector("simulatedDeviceFamily")
	public native NSNumber simulatedDeviceFamily();

	@Generated
	@Selector("simulatedDeviceInfoName")
	public native String simulatedDeviceInfoName();

	@Generated
	@Selector("simulatedDisplayHeight")
	public native NSNumber simulatedDisplayHeight();

	@Generated
	@Selector("simulatedDisplayScale")
	public native NSNumber simulatedDisplayScale();

	@Generated
	@Selector("simulatedSystemRoot")
	public native DTiPhoneSimulatorSystemRoot simulatedSystemRoot();

	@Generated
	@Selector("stderrFileHandle")
	public native NSFileHandle stderrFileHandle();

	@Generated
	@Selector("stdinFileHandle")
	public native NSFileHandle stdinFileHandle();

	@Generated
	@Selector("stdoutFileHandle")
	public native NSFileHandle stdoutFileHandle();
}
