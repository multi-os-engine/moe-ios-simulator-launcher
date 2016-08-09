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
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.CategoryClassMethod;
import org.moe.natj.objc.ann.ObjCCategory;
import org.moe.natj.objc.ann.Selector;
import mac.foundation.NSString;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCCategory(NSString.class)
public final class NSStringExt {
	static {
		NatJ.register();
	}

	@Generated
	private NSStringExt() {
	}

	@Generated
	@Selector("stringForCPUType:")
	@CategoryClassMethod
	public static native NSString stringForCPUType(int arg1);

	@Generated
	@Selector("cputype")
	public static native int cputype(String _object);
}
