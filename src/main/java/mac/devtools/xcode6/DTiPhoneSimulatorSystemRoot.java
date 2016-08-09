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
import mac.foundation.protocol.NSCopying;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class DTiPhoneSimulatorSystemRoot extends NSObject implements NSCopying {
	static {
		NatJ.register();
	}

	@Generated
	protected DTiPhoneSimulatorSystemRoot(Pointer peer) {
		super(peer);
	}

	@Generated
	@Owned
	@Selector("alloc")
	public static native DTiPhoneSimulatorSystemRoot alloc();

	@Generated
	@Selector("compare:")
	public native long compare(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Owned
	@Selector("copyWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object copyWithZone(VoidPtr arg1);

	@Generated
	@Selector("defaultRoot")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object defaultRoot();

	@Generated
	@Selector("initWithRuntime:")
	public native DTiPhoneSimulatorSystemRoot initWithRuntime(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("initialize")
	public static native void initialize();

	@Generated
	@Selector("isEqual:")
	public native boolean isEqual(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("knownRoots")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object knownRoots();

	@Generated
	@Selector("rootWithSDKPath:")
	public static native DTiPhoneSimulatorSystemRoot rootWithSDKPath(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("rootWithSDKVersion:")
	public static native DTiPhoneSimulatorSystemRoot rootWithSDKVersion(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("rootWithSimRuntime:")
	public static native DTiPhoneSimulatorSystemRoot rootWithSimRuntime(
			SimRuntime arg1);

	@Generated
	@Selector("runtime")
	public native SimRuntime runtime();

	@Generated
	@Selector("sdkDisplayName")
	public native String sdkDisplayName();

	@Generated
	@Selector("sdkRootPath")
	public native String sdkRootPath();

	@Generated
	@Selector("sdkVersion")
	public native String sdkVersion();

	@Generated
	@Selector("init")
	public native DTiPhoneSimulatorSystemRoot init();
}
