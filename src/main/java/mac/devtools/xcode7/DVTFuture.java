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
import org.moe.natj.objc.ObjCObject;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class DVTFuture extends ObjCObject {
	static {
		NatJ.register();
	}

	@Generated
	protected DVTFuture(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("_description")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _description();

	@Generated
	@Selector("_internalSetState:result:error:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _internalSetStateResultError(long arg1, @Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3);

	@Generated
	@Selector("_setState:result:error:afterTimeout:")
	public native void _setStateResultErrorAfterTimeout(long arg1, @Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3, double arg4);

	@Generated
	@Selector("_signalFinished")
	public native void _signalFinished();

	@Generated
	@Selector("_waitUntilFinished")
	public native void _waitUntilFinished();

	@Generated
	@Owned
	@Selector("alloc")
	public static native DVTFuture alloc();

	@Generated
	@Selector("cancel")
	public native void cancel();

	@Generated
	@Selector("cancelAfterTimeout:")
	public native void cancelAfterTimeout(double arg1);

	@Generated
	@Selector("cancelledFuture")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object cancelledFuture();

	@Generated
	@Selector("dealloc")
	public native void dealloc();

	@Generated
	@Selector("error")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object error();

	@Generated
	@Selector("failWithError:")
	public native void failWithError(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("failWithError:afterTimeout:")
	public native void failWithErrorAfterTimeout(@Mapped(ObjCObjectMapper.class) Object arg1, double arg2);

	@Generated
	@Selector("future")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object future();

	@Generated
	@Selector("futureWithBlock:")
	public static native DVTFuture futureWithBlock(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("futureWithError:")
	public static native DVTFuture futureWithError(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("futureWithOperation:")
	public static native DVTFuture futureWithOperation(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("futureWithResult:")
	public static native DVTFuture futureWithResult(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("init")
	public native DVTFuture init();

	@Generated
	@Selector("initWithBlock:")
	public native DVTFuture initWithBlock(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("initWithError:")
	public native DVTFuture initWithError(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("initWithResult:")
	public native DVTFuture initWithResult(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("observeCancellation:")
	public native void observeCancellation(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("observeFailure:")
	public native void observeFailure(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("observeFinish:")
	public native void observeFinish(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("observeFinishOnQueue:withBlock:")
	public native void observeFinishOnQueueWithBlock(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("observeFinishWithDispatchGroup:")
	public native void observeFinishWithDispatchGroup(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("observeProgress:")
	public native void observeProgress(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("observeSuccess:")
	public native void observeSuccess(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("result")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object result();

	@Generated
	@Selector("runOperation:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object runOperation(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("setProgress:")
	public native void setProgress(long arg1);

	@Generated
	@Selector("setState:result:error:")
	public native void setStateResultError(long arg1, @Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3);

	@Generated
	@Selector("succeedWithResult:")
	public native void succeedWithResult(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("succeedWithResult:afterTimeout:")
	public native void succeedWithResultAfterTimeout(@Mapped(ObjCObjectMapper.class) Object arg1, double arg2);

	@Generated
	@Selector("then:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object then(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("trackFuture:")
	public native void trackFuture(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("trackFuture:progress:cancel:result:error:")
	public native void trackFutureProgressCancelResultError(@Mapped(ObjCObjectMapper.class) Object arg1, float arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3, @Mapped(ObjCObjectMapper.class) Object arg4,
			@Mapped(ObjCObjectMapper.class) Object arg5);

	@Generated
	@Selector("trackOperation:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object trackOperation(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("updateProgressFromReporters")
	public native void updateProgressFromReporters();

	@Generated
	@Selector("waitUntilFinished")
	public native long waitUntilFinished();
}
