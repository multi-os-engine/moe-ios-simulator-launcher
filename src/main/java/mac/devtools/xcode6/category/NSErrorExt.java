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

package mac.devtools.xcode6.category;


import org.moe.natj.general.NatJ;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.MappedReturn;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.CategoryClassMethod;
import org.moe.natj.objc.ann.ObjCCategory;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;
import mac.foundation.NSError;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCCategory(NSError.class)
public final class NSErrorExt {
	static {
		NatJ.register();
	}

	@Generated
	private NSErrorExt() {
	}

	@Generated
	@Selector("errorFromXPCDict:")
	@CategoryClassMethod
	public static native NSError errorFromXPCDict(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("errorWithLaunchdError:")
	@CategoryClassMethod
	public static native NSError errorWithLaunchdError(int arg1);

	@Generated
	@Selector("errorWithLaunchdError:localizedDescription:")
	@CategoryClassMethod
	public static native NSError errorWithLaunchdErrorLocalizedDescription(
			int arg1, @Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("errorWithLaunchdError:userInfo:")
	@CategoryClassMethod
	public static native NSError errorWithLaunchdErrorUserInfo(int arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("errorWithSimErrno:")
	@CategoryClassMethod
	public static native NSError errorWithSimErrno(int arg1);

	@Generated
	@Selector("errorWithSimErrno:localizedDescription:")
	@CategoryClassMethod
	public static native NSError errorWithSimErrnoLocalizedDescription(
			int arg1, @Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("errorWithSimErrno:userInfo:")
	@CategoryClassMethod
	public static native NSError errorWithSimErrnoUserInfo(int arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("xpcDict")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object xpcDict(NSError _object);
}
