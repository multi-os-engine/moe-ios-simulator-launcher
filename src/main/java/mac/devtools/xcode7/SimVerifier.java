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
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;
import mac.NSObject;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SimVerifier extends NSObject {
	static {
		NatJ.register();
	}

	@Generated
	protected SimVerifier(Pointer peer) {
		super(peer);
	}

	@Generated
	@Owned
	@Selector("alloc")
	public static native SimVerifier alloc();

	@Generated
	@Selector("connectionError")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object connectionError();

	@Generated
	@Selector("init")
	public native SimVerifier init();

	@Generated
	@Selector("serviceConnection")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object serviceConnection();

	@Generated
	@Selector("serviceConnectionQueue")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object serviceConnectionQueue();

	@Generated
	@Selector("setServiceConnection:")
	public native void setServiceConnection(
			@Mapped(ObjCObjectMapper.class) Object value);

	@Generated
	@Selector("setServiceConnectionQueue:")
	public native void setServiceConnectionQueue(
			@Mapped(ObjCObjectMapper.class) Object value);

	@Generated
	@Selector("sharedVerifier")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object sharedVerifier();

	@Generated
	@Selector("verificationError:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object verificationError(int arg1);

	@Generated
	@Selector("verifyAll")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object verifyAll();

	@Generated
	@Selector("verifyAllWithError:")
	public native boolean verifyAllWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("verifyDyldSim:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object verifyDyldSim(
			@Mapped(ObjCObjectMapper.class) Object arg1);
}
