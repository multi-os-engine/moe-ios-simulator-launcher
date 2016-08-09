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
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import mac.NSObject;
import mac.devtools.xcode7.protocol.IDEConsoleAdaptorDelegateProtocol;
import mac.foundation.NSFileHandle;

@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class IDEConsoleAdaptor extends NSObject {
    static {
        NatJ.register();
    }

    protected IDEConsoleAdaptor(Pointer peer) {
        super(peer);
    }

    @Owned
    @Selector("alloc")
    public static native IDEConsoleAdaptor alloc();

    @Selector("initWithType:standardInput:standardOutput:standardError:")
    public native IDEConsoleAdaptor initWithTypeStandardInputStandardOutputStandardError(String type, NSFileHandle input, NSFileHandle output, NSFileHandle error);

    @Selector("setDelegate:")
    public native void setDelegate(IDEConsoleAdaptorDelegateProtocol delegate);
}
