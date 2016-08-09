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


import org.moe.ios.simulator.launcher.Configuration;
import org.moe.natj.c.map.CStringMapper;
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
import mac.foundation.*;

import java.util.ArrayList;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SimDevice extends NSObject implements SimDeviceNotifier {
	static {
		NatJ.register();
	}

	@Generated
	protected SimDevice(Pointer peer) {
		super(peer);
	}

    private static ArrayList<SimDevice> getAllDevices(Configuration config) {
		final SimDeviceSet defaultSet = SimDeviceSet.defaultSet();
		final NSArray devices = defaultSet.availableDevices();

        //Hack: Force init of class
        SimDevice.alloc().init();

		if (devices == null) {
			return new ArrayList<SimDevice>();
		}

		final ArrayList<SimDevice> devs = new ArrayList<SimDevice>();
		for (int i = 0; i < devices.count(); ++i) {
			final SimDevice device = (SimDevice) devices.objectAtIndex(i);
			final String rt = device.runtime().name();
			if (rt == null) {
				continue;
			}
			if (config.getTargetPlatformTvOS()) {
				if ("tvOS".equals(rt) || rt.startsWith("tvOS ")) {
					devs.add(device);
				}
			} else if (config.getTargetPlatformWatchOS()) {
				if ("watchOS".equals(rt) || rt.startsWith("watchOS ")) {
					devs.add(device);
				}
			} else {
				if ("iOS".equals(rt) || rt.startsWith("iOS ")) {
					devs.add(device);
				}
			}
		}

        return devs;
    }

    public static void printDevices(Configuration config) {
		for (SimDevice device : getAllDevices(config)) {
			System.out.println("- " + device.name() + " - " + device.runtime().versionString() +
					" (" + device.UDID().UUIDString() + ")");
		}
    }

    public static SimDevice getDevice(String udid, Configuration config) {
        ArrayList<SimDevice> devices = getAllDevices(config);

        if (udid == null || udid.length() == 0) {
            if (devices.size() > 0) {
                return (SimDevice) devices.get(0);
            } else {
                throw new RuntimeException("There are no devices in the simulator");
            }
        } else {
            udid = udid.toUpperCase();

            for (int i = 0; i < devices.size(); ++i) {
                SimDevice device = (SimDevice) devices.get(i);
                if (device.UDID().UUIDString().equals(udid)) {
                    return device;
                }
            }
            throw new RuntimeException("Device with UDID " + udid + " could not be found in the simulator");
        }
    }

	@Generated
	@Selector("UDID")
	public native NSUUID UDID();

	@Generated
	@Selector("_lookup:error:")
	public native int _lookupError(@Mapped(ObjCObjectMapper.class) Object arg1,
			Ptr<ObjCObject> arg2);

	@Generated
	@Selector("_sendUIWindowPropertiesToDevice")
	public native void _sendUIWindowPropertiesToDevice();

	@Generated
	@Selector("_shutdownWithError:")
	public native boolean _shutdownWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("_spawnFromLaunchdWithPath:options:terminationHandler:error:")
	public native int _spawnFromLaunchdWithPathOptionsTerminationHandlerError(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@ObjCBlock(name = "call__spawnFromLaunchdWithPathOptionsTerminationHandlerError") Block__spawnFromLaunchdWithPathOptionsTerminationHandlerError arg3,
			Ptr<ObjCObject> arg4);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block__spawnFromLaunchdWithPathOptionsTerminationHandlerError {
		@Generated
		public void call__spawnFromLaunchdWithPathOptionsTerminationHandlerError();
	}

	@Generated
	@Selector("_spawnFromSelfWithPath:options:terminationHandler:error:")
	public native int _spawnFromSelfWithPathOptionsTerminationHandlerError(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@ObjCBlock(name = "call__spawnFromSelfWithPathOptionsTerminationHandlerError") Block__spawnFromSelfWithPathOptionsTerminationHandlerError arg3,
			Ptr<ObjCObject> arg4);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block__spawnFromSelfWithPathOptionsTerminationHandlerError {
		@Generated
		public void call__spawnFromSelfWithPathOptionsTerminationHandlerError();
	}

	@Generated
	@Selector("addPhoto:error:")
	public native boolean addPhotoError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Owned
	@Selector("alloc")
	public static native SimDevice alloc();

	@Generated
	@Selector("applicationIsInstalled:type:error:")
	public native boolean applicationIsInstalledTypeError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2,
			Ptr<ObjCObject> arg3);

	@Generated
	@Selector("available")
	public native boolean available();

	@Generated
	@Selector("bootAsyncWithOptions:completionHandler:")
	public native void bootAsyncWithOptionsCompletionHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_bootAsyncWithOptionsCompletionHandler") Block_bootAsyncWithOptionsCompletionHandler arg2);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_bootAsyncWithOptionsCompletionHandler {
		@Generated
		public void call_bootAsyncWithOptionsCompletionHandler();
	}

	@Generated
	@Selector("bootWithOptions:error:")
	public native boolean bootWithOptionsError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("bootstrapQueue")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object bootstrapQueue();

	@Generated
	@Selector("clearTmpWithError:")
	public native boolean clearTmpWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("compare:")
	public native long compare(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("connectionManager")
	public native SimServiceConnectionManager connectionManager();

	@Generated
	@Selector("createDeviceWithName:setPath:deviceType:runtime:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object createDeviceWithNameSetPathDeviceTypeRuntime(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3,
			@Mapped(ObjCObjectMapper.class) Object arg4);

	@Generated
	@Selector("createLaunchdJobWithError:extraEnvironment:disabledJobs:")
	public native boolean createLaunchdJobWithErrorExtraEnvironmentDisabledJobs(
			Ptr<ObjCObject> arg1, @Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3);

	@Generated
	@Selector("createXPCNotification:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object createXPCNotification(
			@UncertainArgument("Options: java.string, c.const-byte-ptr Fallback: java.string") @Mapped(CStringMapper.class) String arg1);

	@Generated
	@Selector("createXPCRequest:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object createXPCRequest(
			@UncertainArgument("Options: java.string, c.const-byte-ptr Fallback: java.string") @Mapped(CStringMapper.class) String arg1);

	@Generated
	@Selector("dataPath")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dataPath();

	@Generated
	@Selector("deathTriggerPort")
	public native NSMachPort deathTriggerPort();

	@Generated
	@Selector("descriptiveName")
	public native String descriptiveName();

	@Generated
	@Selector("devicePath")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object devicePath();

	@Generated
	@Selector("deviceSet")
	public native SimDeviceSet deviceSet();

	@Generated
	@Selector("deviceType")
	public native SimDeviceType deviceType();

	@Generated
	@Selector("dvt_applicationIsInstalledWithBundleIdentifier:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_applicationIsInstalledWithBundleIdentifier(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("dvt_boot")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_boot();

	@Generated
	@Selector("dvt_bootWithOptions:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_bootWithOptions(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("dvt_eraseContentsAndSettings")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_eraseContentsAndSettings();

	@Generated
	@Selector("dvt_installApplicationAtPath:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_installApplicationAtPath(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("dvt_installApplicationAtPath:withOptions:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_installApplicationAtPathWithOptions(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("dvt_launchApplicationWithBundleIdentifier:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_launchApplicationWithBundleIdentifier(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("dvt_launchApplicationWithBundleIdentifier:andOptions:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_launchApplicationWithBundleIdentifierAndOptions(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("dvt_notifyOfBootOnQueue:handler:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_notifyOfBootOnQueueHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_dvt_notifyOfBootOnQueueHandler") Block_dvt_notifyOfBootOnQueueHandler arg2);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_dvt_notifyOfBootOnQueueHandler {
		@Generated
		public void call_dvt_notifyOfBootOnQueueHandler();
	}

	@Generated
	@Selector("dvt_registerNotificationHandler:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_registerNotificationHandler(
			@ObjCBlock(name = "call_dvt_registerNotificationHandler") Block_dvt_registerNotificationHandler arg1);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_dvt_registerNotificationHandler {
		@Generated
		public void call_dvt_registerNotificationHandler();
	}

	@Generated
	@Selector("dvt_registerNotificationHandlerOnQueue:handler:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_registerNotificationHandlerOnQueueHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_dvt_registerNotificationHandlerOnQueueHandler") Block_dvt_registerNotificationHandlerOnQueueHandler arg2);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_dvt_registerNotificationHandlerOnQueueHandler {
		@Generated
		public void call_dvt_registerNotificationHandlerOnQueueHandler();
	}

	@Generated
	@Selector("dvt_restoreContentsAndSettingsFrom:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_restoreContentsAndSettingsFrom(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("dvt_shutdown")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_shutdown();

	@Generated
	@Selector("dvt_spawnExecutableAtPath:withOptions:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_spawnExecutableAtPathWithOptions(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("dvt_spawnExecutableAtPath:withOptions:andTerminationHandler:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_spawnExecutableAtPathWithOptionsAndTerminationHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@ObjCBlock(name = "call_dvt_spawnExecutableAtPathWithOptionsAndTerminationHandler") Block_dvt_spawnExecutableAtPathWithOptionsAndTerminationHandler arg3);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_dvt_spawnExecutableAtPathWithOptionsAndTerminationHandler {
		@Generated
		public void call_dvt_spawnExecutableAtPathWithOptionsAndTerminationHandler();
	}

	@Generated
	@Selector("dvt_uninstallApplicationWithBundleIdentifier:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_uninstallApplicationWithBundleIdentifier(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("dvt_uninstallApplicationWithBundleIdentifier:andOptions:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_uninstallApplicationWithBundleIdentifierAndOptions(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("ensureLogPathsWithError:")
	public native boolean ensureLogPathsWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("environment")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object environment();

	@Generated
	@Selector("eraseContentsAndSettingsAsyncWithCompletionHandler:")
	public native void eraseContentsAndSettingsAsyncWithCompletionHandler(
			@ObjCBlock(name = "call_eraseContentsAndSettingsAsyncWithCompletionHandler") Block_eraseContentsAndSettingsAsyncWithCompletionHandler arg1);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_eraseContentsAndSettingsAsyncWithCompletionHandler {
		@Generated
		public void call_eraseContentsAndSettingsAsyncWithCompletionHandler();
	}

	@Generated
	@Selector("eraseContentsAndSettingsWithError:")
	public native boolean eraseContentsAndSettingsWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("getenv:error:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object getenvError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("handleXPCNotification:")
	public native void handleXPCNotification(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("handleXPCNotificationDeviceRenamed:")
	public native void handleXPCNotificationDeviceRenamed(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("handleXPCNotificationDeviceStateChanged:")
	public native void handleXPCNotificationDeviceStateChanged(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("handleXPCNotificationDeviceUIWindowPropertiesChanged:")
	public native void handleXPCNotificationDeviceUIWindowPropertiesChanged(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("handleXPCRequest:peer:")
	public native void handleXPCRequestPeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestBoot:peer:")
	public native void handleXPCRequestBootPeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestErase:peer:")
	public native void handleXPCRequestErasePeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestGetenv:peer:")
	public native void handleXPCRequestGetenvPeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestLookup:peer:")
	public native void handleXPCRequestLookupPeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestRegister:peer:")
	public native void handleXPCRequestRegisterPeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestRename:peer:")
	public native void handleXPCRequestRenamePeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestRestore:peer:")
	public native void handleXPCRequestRestorePeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestShutdown:peer:")
	public native void handleXPCRequestShutdownPeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestSpawn:peer:")
	public native void handleXPCRequestSpawnPeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestUpdateUIWindow:peer:")
	public native void handleXPCRequestUpdateUIWindowPeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("handleXPCRequestUpgrade:peer:")
	public native void handleXPCRequestUpgradePeer(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("hostSupportPort")
	public native NSMachPort hostSupportPort();

	@Generated
	@Selector("initDevice:UDID:deviceType:runtime:state:connectionManager:setPath:")
	public native SimDevice initDeviceUDIDDeviceTypeRuntimeStateConnectionManagerSetPath(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3,
			@Mapped(ObjCObjectMapper.class) Object arg4, long arg5,
			@Mapped(ObjCObjectMapper.class) Object arg6,
			@Mapped(ObjCObjectMapper.class) Object arg7);

	@Generated
	@Selector("installApplication:withOptions:error:")
	public native boolean installApplicationWithOptionsError(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, Ptr<ObjCObject> arg3);

	@Generated
	@Selector("installedAppsWithError:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object installedAppsWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("isAvailableWithError:")
	public native boolean isAvailableWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("isValidState:")
	public static native boolean isValidState(long arg1);

	@Generated
	@Selector("launchApplicationAsyncWithID:options:completionHandler:")
	public native void launchApplicationAsyncWithIDOptionsCompletionHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@ObjCBlock(name = "call_launchApplicationAsyncWithIDOptionsCompletionHandler") Block_launchApplicationAsyncWithIDOptionsCompletionHandler arg3);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_launchApplicationAsyncWithIDOptionsCompletionHandler {
		@Generated
		public void call_launchApplicationAsyncWithIDOptionsCompletionHandler();
	}

	@Generated
	@Selector("launchApplicationWithID:options:error:")
	public native int launchApplicationWithIDOptionsError(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, Ptr<ObjCObject> arg3);

	@Generated
	@Selector("launchDaemonsPaths")
	public native NSArray launchDaemonsPaths();

	@Generated
	@Selector("launchdDeathHandlerWithDeathPort:")
	public native void launchdDeathHandlerWithDeathPort(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("launchdJobName")
	public native String launchdJobName();

	@Generated
	@Selector("logPath")
	public native String logPath();

	@Generated
	@Selector("lookup:error:")
	public native int lookupError(@Mapped(ObjCObjectMapper.class) Object arg1,
			Ptr<ObjCObject> arg2);

	@Generated
	@Selector("memoryWarningFilePath")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object memoryWarningFilePath();

	@Generated
	@Selector("name")
	public native String name();

	@Generated
	@Selector("newDeviceNotification")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object newDeviceNotification();

	@Generated
	@Selector("notificationManager")
	public native SimDeviceNotificationManager notificationManager();

	@Generated
	@Selector("openURL:error:")
	public native boolean openURLError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("postDarwinNotification:error:")
	public native boolean postDarwinNotificationError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

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
	@Selector("registerPort:service:error:")
	public native boolean registerPortServiceError(int arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, Ptr<ObjCObject> arg3);

	@Generated
	@Selector("registerPortsWithLaunchd")
	public native void registerPortsWithLaunchd();

	@Generated
	@Selector("registeredServices")
	public native NSMutableDictionary registeredServices();

	@Generated
	@Selector("removeLaunchdJobWithError:")
	public native boolean removeLaunchdJobWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("rename:error:")
	public native boolean renameError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("renameAsync:completionHandler:")
	public native void renameAsyncCompletionHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_renameAsyncCompletionHandler") Block_renameAsyncCompletionHandler arg2);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_renameAsyncCompletionHandler {
		@Generated
		public void call_renameAsyncCompletionHandler();
	}

	@Generated
	@Selector("restoreContentsAndSettingsAsyncFromDevice:completionHandler:")
	public native void restoreContentsAndSettingsAsyncFromDeviceCompletionHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_restoreContentsAndSettingsAsyncFromDeviceCompletionHandler") Block_restoreContentsAndSettingsAsyncFromDeviceCompletionHandler arg2);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_restoreContentsAndSettingsAsyncFromDeviceCompletionHandler {
		@Generated
		public void call_restoreContentsAndSettingsAsyncFromDeviceCompletionHandler();
	}

	@Generated
	@Selector("restoreContentsAndSettingsFromDevice:error:")
	public native boolean restoreContentsAndSettingsFromDeviceError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("runtime")
	public native SimRuntime runtime();

	@Generated
	@Selector("saveStateDict")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object saveStateDict();

	@Generated
	@Selector("saveToDisk")
	public native void saveToDisk();

	@Generated
	@Selector("setBootstrapQueue:")
	public native void setBootstrapQueue(
			@Mapped(ObjCObjectMapper.class) Object value);

	@Generated
	@Selector("setConnectionManager:")
	public native void setConnectionManager(SimServiceConnectionManager value);

	@Generated
	@Selector("setDeathTriggerPort:")
	public native void setDeathTriggerPort(NSMachPort value);

	@Generated
	@Selector("setDeviceType:")
	public native void setDeviceType(SimDeviceType value);

	@Generated
	@Selector("setHostSupportPort:")
	public native void setHostSupportPort(NSMachPort value);

	@Generated
	@Selector("setKeyboardLanguage:error:")
	public native boolean setKeyboardLanguageError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("setName:")
	public native void setName(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("setNotificationManager:")
	public native void setNotificationManager(SimDeviceNotificationManager value);

	@Generated
	@Selector("setPath")
	public native String setPath();

	@Generated
	@Selector("setRegisteredServices:")
	public native void setRegisteredServices(NSMutableDictionary value);

	@Generated
	@Selector("setRuntime:")
	public native void setRuntime(SimRuntime value);

	@Generated
	@Selector("setSetPath:")
	public native void setSetPath(String value);

	@Generated
	@Selector("setSimBridgeDistantObject:")
	public native void setSimBridgeDistantObject(NSDistantObject value);

	@Generated
	@Selector("setSimBridgePort:")
	public native void setSimBridgePort(NSMachPort value);

	@Generated
	@Selector("setState:")
	public native void setState(long arg1);

	@Generated
	@Selector("setStateVariableQueue:")
	public native void setStateVariableQueue(
			@Mapped(ObjCObjectMapper.class) Object value);

	@Generated
	@Selector("setUDID:")
	public native void setUDID(NSUUID value);

	@Generated
	@Selector("setUiWindowProperties:")
	public native void setUiWindowProperties(NSDictionary value);

	@Generated
	@Selector("shutdownAsyncWithCompletionHandler:")
	public native void shutdownAsyncWithCompletionHandler(
			@ObjCBlock(name = "call_shutdownAsyncWithCompletionHandler") Block_shutdownAsyncWithCompletionHandler arg1);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_shutdownAsyncWithCompletionHandler {
		@Generated
		public void call_shutdownAsyncWithCompletionHandler();
	}

	@Generated
	@Selector("shutdownWithError:")
	public native boolean shutdownWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("simBridgeAsync:")
	public native void simBridgeAsync(
			@ObjCBlock(name = "call_simBridgeAsync") Block_simBridgeAsync arg1);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_simBridgeAsync {
		@Generated
		public void call_simBridgeAsync();
	}

	@Generated
	@Selector("simBridgeCommon:")
	public native void simBridgeCommon(
			@ObjCBlock(name = "call_simBridgeCommon") Block_simBridgeCommon arg1);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_simBridgeCommon {
		@Generated
		public void call_simBridgeCommon();
	}

	@Generated
	@Selector("simBridgeDistantObject")
	public native NSDistantObject simBridgeDistantObject();

	@Generated
	@Selector("simBridgePort")
	public native NSMachPort simBridgePort();

	@Generated
	@Selector("simBridgeSync:")
	public native void simBridgeSync(
			@ObjCBlock(name = "call_simBridgeSync") Block_simBridgeSync arg1);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_simBridgeSync {
		@Generated
		public void call_simBridgeSync();
	}

	@Generated
	@Selector("simDevice:UDID:deviceType:runtime:state:connectionManager:setPath:")
	public static native SimDevice simDeviceUDIDDeviceTypeRuntimeStateConnectionManagerSetPath(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3,
			@Mapped(ObjCObjectMapper.class) Object arg4, long arg5,
			@Mapped(ObjCObjectMapper.class) Object arg6,
			@Mapped(ObjCObjectMapper.class) Object arg7);

	@Generated
	@Selector("simDeviceAtPath:")
	public static native SimDevice simDeviceAtPath(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("simulateMemoryWarning")
	public native void simulateMemoryWarning();

	@Generated
	@Selector("spawnAsyncWithPath:options:terminationHandler:completionHandler:")
	public native void spawnAsyncWithPathOptionsTerminationHandlerCompletionHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@ObjCBlock(name = "call_spawnAsyncWithPathOptionsTerminationHandlerCompletionHandler_2") Block_spawnAsyncWithPathOptionsTerminationHandlerCompletionHandler_2 arg3,
			@ObjCBlock(name = "call_spawnAsyncWithPathOptionsTerminationHandlerCompletionHandler_3") Block_spawnAsyncWithPathOptionsTerminationHandlerCompletionHandler_3 arg4);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_spawnAsyncWithPathOptionsTerminationHandlerCompletionHandler_2 {
		@Generated
		public void call_spawnAsyncWithPathOptionsTerminationHandlerCompletionHandler_2();
	}

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_spawnAsyncWithPathOptionsTerminationHandlerCompletionHandler_3 {
		@Generated
		public void call_spawnAsyncWithPathOptionsTerminationHandlerCompletionHandler_3();
	}

	@Generated
	@Selector("spawnWithPath:options:terminationHandler:error:")
	public native int spawnWithPathOptionsTerminationHandlerError(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2,
			@ObjCBlock(name = "call_spawnWithPathOptionsTerminationHandlerError") Block_spawnWithPathOptionsTerminationHandlerError arg3,
			Ptr<ObjCObject> arg4);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_spawnWithPathOptionsTerminationHandlerError {
		@Generated
		public void call_spawnWithPathOptionsTerminationHandlerError();
	}

	@Generated
	@Selector("startLaunchdWithDeathPort:deathHandler:error:")
	public native boolean startLaunchdWithDeathPortDeathHandlerError(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_startLaunchdWithDeathPortDeathHandlerError") Block_startLaunchdWithDeathPortDeathHandlerError arg2,
			Ptr<ObjCObject> arg3);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_startLaunchdWithDeathPortDeathHandlerError {
		@Generated
		public void call_startLaunchdWithDeathPortDeathHandlerError();
	}

	@Generated
	@Selector("state")
	public native long state();

	@Generated
	@Selector("stateString")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object stateString();

	@Generated
	@Selector("stateVariableQueue")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object stateVariableQueue();

	@Generated
	@Selector("supportsFeature:")
	public native boolean supportsFeature(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("triggerCloudSyncWithCompletionHandler:")
	public native void triggerCloudSyncWithCompletionHandler(
			@ObjCBlock(name = "call_triggerCloudSyncWithCompletionHandler") Block_triggerCloudSyncWithCompletionHandler arg1);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_triggerCloudSyncWithCompletionHandler {
		@Generated
		public void call_triggerCloudSyncWithCompletionHandler();
	}

	@Generated
	@Selector("triggerCloudSyncWithError:")
	public native boolean triggerCloudSyncWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("uiWindowProperties")
	public native NSDictionary uiWindowProperties();

	@Generated
	@Selector("uninstallApplication:withOptions:error:")
	public native boolean uninstallApplicationWithOptionsError(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, Ptr<ObjCObject> arg3);

	@Generated
	@Selector("unregisterNotificationHandler:error:")
	public native boolean unregisterNotificationHandlerError(long arg1,
			Ptr<ObjCObject> arg2);

	@Generated
	@Selector("updateAsyncUIWindowProperties:completionHandler:")
	public native void updateAsyncUIWindowPropertiesCompletionHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_updateAsyncUIWindowPropertiesCompletionHandler") Block_updateAsyncUIWindowPropertiesCompletionHandler arg2);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_updateAsyncUIWindowPropertiesCompletionHandler {
		@Generated
		public void call_updateAsyncUIWindowPropertiesCompletionHandler();
	}

	@Generated
	@Selector("updateUIWindowProperties:error:")
	public native boolean updateUIWindowPropertiesError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("upgradeAsyncToRuntime:completionHandler:")
	public native void upgradeAsyncToRuntimeCompletionHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1,
			@ObjCBlock(name = "call_upgradeAsyncToRuntimeCompletionHandler") Block_upgradeAsyncToRuntimeCompletionHandler arg2);

	@Runtime(ObjCRuntime.class)
	@Generated
	static public interface Block_upgradeAsyncToRuntimeCompletionHandler {
		@Generated
		public void call_upgradeAsyncToRuntimeCompletionHandler();
	}

	@Generated
	@Selector("upgradeToRuntime:error:")
	public native boolean upgradeToRuntimeError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("validateAndFixState")
	public native void validateAndFixState();

	@Generated
	@Selector("init")
	public native SimDevice init();
}
