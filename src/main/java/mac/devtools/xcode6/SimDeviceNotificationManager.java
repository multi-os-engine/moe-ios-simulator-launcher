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
import org.moe.natj.general.ptr.Ptr;
import org.moe.natj.objc.ObjCObject;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCBlock;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;
import mac.NSObject;
import mac.devtools.xcode6.protocol.SimDeviceNotifier;
import mac.foundation.NSMutableDictionary;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SimDeviceNotificationManager extends NSObject implements
		SimDeviceNotifier {
	static {
		NatJ.register();
	}

	@Generated
	protected SimDeviceNotificationManager(Pointer peer) {
		super(peer);
	}

	@Generated
	@Owned
	@Selector("alloc")
	public static native SimDeviceNotificationManager alloc();

	@Generated
	@Selector("handlers")
	public native NSMutableDictionary handlers();

	@Generated
	@Selector("handlersQueue")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object handlersQueue();

	@Generated
	@Selector("init")
	public native SimDeviceNotificationManager init();

	@Generated
	@Selector("next_regID")
	public native long next_regID();

	@Generated
	@Selector("registerNotificationHandler:")
	public native long registerNotificationHandler(
			@ObjCBlock(name = "call_registerNotificationHandler") SimDeviceNotifier.Block_registerNotificationHandler arg1);

	@Generated
	@Selector("registerNotificationHandlerOnQueue:handler:")
	public native long registerNotificationHandlerOnQueueHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_registerNotificationHandlerOnQueueHandler") SimDeviceNotifier.Block_registerNotificationHandlerOnQueueHandler arg2);

	@Generated
	@Selector("sendNotification:")
	public native void sendNotification(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("sendQueue")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object sendQueue();

	@Generated
	@Selector("setHandlers:")
	public native void setHandlers(NSMutableDictionary value);

	@Generated
	@Selector("setHandlersQueue:")
	public native void setHandlersQueue(
			@Mapped(ObjCObjectMapper.class) Object value);

	@Generated
	@Selector("setNext_regID:")
	public native void setNext_regID(long value);

	@Generated
	@Selector("setSendQueue:")
	public native void setSendQueue(@Mapped(ObjCObjectMapper.class) Object value);

	@Generated
	@Selector("unregisterNotificationHandler:error:")
	public native boolean unregisterNotificationHandlerError(long arg1,
			Ptr<ObjCObject> arg2);
}
