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
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class DVTiPhoneSimulatorCoreSimMessenger extends
		DVTiPhoneSimulatorMessenger {
	static {
		NatJ.register();
	}

	@Generated
	protected DVTiPhoneSimulatorCoreSimMessenger(Pointer peer) {
		super(peer);
	}

	@Generated
	@Owned
	@Selector("alloc")
	public static native DVTiPhoneSimulatorCoreSimMessenger alloc();

	@Generated
	@Selector("backgroundAllApps:")
	public native void backgroundAllApps(int arg1);

	@Generated
	@Selector("doFetchEventForPID:")
	public native void doFetchEventForPID(int arg1);

	@Generated
	@Selector("doUbiquityFetchEvent")
	public native void doUbiquityFetchEvent();

	@Generated
	@Selector("initWithSession:")
	public native DVTiPhoneSimulatorCoreSimMessenger initWithSession(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("installApplicationWithConfig:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object installApplicationWithConfig(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("launchApplicationWithConfig:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object launchApplicationWithConfig(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("messengerForSession:")
	public static native DVTiPhoneSimulatorCoreSimMessenger messengerForSession(
			@Mapped(ObjCObjectMapper.class) Object arg1);

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
	@Selector("init")
	public native DVTiPhoneSimulatorCoreSimMessenger init();
}
