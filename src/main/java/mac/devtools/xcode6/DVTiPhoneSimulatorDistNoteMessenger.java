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
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCObject;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCBlock;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class DVTiPhoneSimulatorDistNoteMessenger extends ObjCObject {
	static {
		NatJ.register();
	}

	@Generated
	protected DVTiPhoneSimulatorDistNoteMessenger(Pointer peer) {
		super(peer);
	}

	@Generated
	@Owned
	@Selector("alloc")
	public static native DVTiPhoneSimulatorDistNoteMessenger alloc();

	@Generated
	@Selector("backgroundAllApps:")
	public native void backgroundAllApps(int arg1);

	@Generated
	@Selector("initialize")
	public static native void initialize();

	@Generated
	@Selector("primitiveInvalidate")
	public native void primitiveInvalidate();

	@Generated
	@Selector("setAppDidLaunchMessageHandler:")
	public native void setAppDidLaunchMessageHandler(
			@ObjCBlock(name = "call_setAppDidLaunchMessageHandler") Block_setAppDidLaunchMessageHandler arg1);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_setAppDidLaunchMessageHandler {
		@Generated
		public void call_setAppDidLaunchMessageHandler();
	}

	@Generated
	@Selector("setToolDidLaunchMessageHandler:")
	public native void setToolDidLaunchMessageHandler(
			@ObjCBlock(name = "call_setToolDidLaunchMessageHandler") Block_setToolDidLaunchMessageHandler arg1);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_setToolDidLaunchMessageHandler {
		@Generated
		public void call_setToolDidLaunchMessageHandler();
	}

	@Generated
	@Selector("startSimulatorSessionWithRequestInfo:")
	public native void startSimulatorSessionWithRequestInfo(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("startSimulatorToolSessionWithParameters:")
	public native void startSimulatorToolSessionWithParameters(
			@Mapped(ObjCObjectMapper.class) Object arg1);
}
