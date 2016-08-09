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
import mac.foundation.NSError;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class DVTiPhoneSimulator extends ObjCObject {
	static {
		NatJ.register();
	}

	@Generated
	protected DVTiPhoneSimulator(Pointer peer) {
		super(peer);
	}

	@Selector("simulatorApplication")
	public native DVTSimulatorApplication simulatorApplication();

	@Generated
	@Selector("_availableArchitecturesForArchitecture:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _availableArchitecturesForArchitecture(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("_canStartSession:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _canStartSession(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("_debugXPCServices:onChannel:completionSemaphore:")
	public native void _debugXPCServicesOnChannelCompletionSemaphore(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, @Mapped(ObjCObjectMapper.class) Object arg3);

	@Generated
	@Selector("_iconForApp:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _iconForApp(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("_installedPathForBundleIdentifier:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _installedPathForBundleIdentifier(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("_launchSimulatorAndUpdateApplicationsWhenReady")
	public native void _launchSimulatorAndUpdateApplicationsWhenReady();

	@Generated
	@Selector("_launchSimulatorAppForLaunchSession:error:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _launchSimulatorAppForLaunchSessionError(@Mapped(ObjCObjectMapper.class) Object arg1,
			Ptr<ObjCObject> arg2);

	@Generated
	@Selector("_launchSimulatorAppWithError:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _launchSimulatorAppWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("_launchSimulatorAppWithExternalDisplayType:andError:")
	@MappedReturn(ObjCObjectMapper.class)
	public native boolean _launchSimulatorAppWithExternalDisplayTypeAndError(long arg1, Ptr<NSError> arg2);

	@Generated
	@Selector("_trackPid:forDevice:")
	public static native void _trackPidForDevice(int arg1, @Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("_updateApplications")
	public native void _updateApplications();

	@Generated
	@Selector("_updateIconForPath:launchSession:")
	public native void _updateIconForPathLaunchSession(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("_waitForSimLaunchdToLoadENVAndReturnTestConnectionSocketPath:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object _waitForSimLaunchdToLoadENVAndReturnTestConnectionSocketPath(Ptr<ObjCObject> arg1);

	@Generated
	@Owned
	@Selector("alloc")
	public static native DVTiPhoneSimulator alloc();

	@Generated
	@Selector("applicationIsInstalledWithBundleIdentifier:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object applicationIsInstalledWithBundleIdentifier(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("attachedToTarget:launchService:error:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object attachedToTargetLaunchServiceError(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, Ptr<ObjCObject> arg3);

	@Generated
	@Selector("boot")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object boot();

	@Generated
	@Selector("bootWithOptions:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object bootWithOptions(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("canBeDefaultDeviceForBuildable:buildParameters:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object canBeDefaultDeviceForBuildableBuildParameters(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("canBeWatchCompanion")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object canBeWatchCompanion();

	@Generated
	@Selector("canIgnore")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object canIgnore();

	@Generated
	@Selector("canInstallApplication")
	@MappedReturn(ObjCObjectMapper.class)
	public native boolean canInstallApplication();

	@Generated
	@Selector("canPerformUbiquityFetchEvent")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object canPerformUbiquityFetchEvent();

	@Generated
	@Selector("canRename")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object canRename();

	@Generated
	@Selector("canRunExecutables")
	@MappedReturn(ObjCObjectMapper.class)
	public native boolean canRunExecutables();

	@Generated
	@Selector("canStartUpAndShutDown")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object canStartUpAndShutDown();

	@Generated
	@Selector("cleanUpSessionMap")
	public static native void cleanUpSessionMap();

	@Generated
	@Selector("dealloc")
	public native void dealloc();

	@Generated
	@Selector("debugXPCServices:onPairedDevice:completionSemaphore:")
	public native void debugXPCServicesOnPairedDeviceCompletionSemaphore(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, @Mapped(ObjCObjectMapper.class) Object arg3);

	@Generated
	@Selector("deviceForRunningUnitTestsWithHost:error:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object deviceForRunningUnitTestsWithHostError(@Mapped(ObjCObjectMapper.class) Object arg1,
			Ptr<ObjCObject> arg2);

	@Generated
	@Selector("deviceSpecificOverridingPropertiesForBuildable:withBaselineParameters:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object deviceSpecificOverridingPropertiesForBuildableWithBaselineParameters(
			@Mapped(ObjCObjectMapper.class) Object arg1, @Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("deviceSummaryPropertyDictionaries")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object deviceSummaryPropertyDictionaries();

	@Generated
	@Selector("deviceType")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object deviceType();

	@Generated
	@Selector("deviceWindowCategory")
	public native int deviceWindowCategory();

	@Generated
	@Selector("displayOrder")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object displayOrder();

	@Generated
	@Selector("downloadOptimizationProfilesFromBundleIdentifier:orPaths:toFilePath:completionHandler:")
	public native void downloadOptimizationProfilesFromBundleIdentifierOrPathsToFilePathCompletionHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1, @Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3, @Mapped(ObjCObjectMapper.class) Object arg4);

	@Generated
	@Selector("dvt_proxiedDeviceImage")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_proxiedDeviceImage();

	@Generated
	@Selector("effectiveSDKVersion")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object effectiveSDKVersion();

	@Generated
	@Selector("eraseContentsAndSettings")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object eraseContentsAndSettings();

	@Generated
	@Selector("executionDisplayName")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object executionDisplayName();

	@Generated
	@Selector("fileManager:shouldCopyItemAtPath:toPath:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object fileManagerShouldCopyItemAtPathToPath(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, @Mapped(ObjCObjectMapper.class) Object arg3);

	@Generated
	@Selector("image")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object image();

	@Generated
	@Selector("initialize")
	public static native void initialize();

	@Generated
	@Selector("installApplicationAtPath:")
	@MappedReturn(ObjCObjectMapper.class)
	public native DVTFuture installApplicationAtPath(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("installApplicationAtPath:withOptions:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object installApplicationAtPathWithOptions(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("installApplicationWithLaunchSession:error:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object installApplicationWithLaunchSessionError(@Mapped(ObjCObjectMapper.class) Object arg1,
			Ptr<ObjCObject> arg2);

	@Generated
	@Selector("isAvailable")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object isAvailable();

	@Generated
	@Selector("isProxiedDevice")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object isProxiedDevice();

	@Generated
	@Selector("keyPathsForValuesAffectingState")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object keyPathsForValuesAffectingState();

	@Generated
	@Selector("launchApplicationWithBundleIdentifier:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object launchApplicationWithBundleIdentifier(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("launchApplicationWithBundleIdentifier:andOptions:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object launchApplicationWithBundleIdentifierAndOptions(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("launchApplicationWithBundleIdentifier:withArguments:environment:options:")
	@MappedReturn(ObjCObjectMapper.class)
	public native DVTFuture launchApplicationWithBundleIdentifierWithArgumentsEnvironmentOptions(
			@Mapped(ObjCObjectMapper.class) Object arg1, @Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3, @Mapped(ObjCObjectMapper.class) Object arg4);

	@Generated
	@Selector("launchSimulatedExecutable:launchService:error:")
	public native boolean launchSimulatedExecutableLaunchServiceError(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, Ptr<NSError> arg3);

	@Generated
	@Selector("makeTransportForTestManagerService:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object makeTransportForTestManagerService(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("modelCode")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object modelCode();

	@Generated
	@Selector("modelName")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object modelName();

	@Generated
	@Selector("modelUTI")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object modelUTI();

	@Generated
	@Selector("name")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object name();

	@Generated
	@Selector("nativeArchitecture")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object nativeArchitecture();

	@Generated
	@Selector("operatingSystemBuild")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object operatingSystemBuild();

	@Generated
	@Selector("operatingSystemVersion")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object operatingSystemVersion();

	@Generated
	@Selector("operatingSystemVersionWithBuildNumber")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object operatingSystemVersionWithBuildNumber();

	@Generated
	@Selector("outputReceived:fromProcess:atTime:")
	public native void outputReceivedFromProcessAtTime(@Mapped(ObjCObjectMapper.class) Object arg1, int arg2,
			long arg3);

	@Generated
	@Selector("performFetchEventForPID:")
	public native void performFetchEventForPID(int arg1);

	@Generated
	@Selector("performUbiquityFetchEvent")
	public native void performUbiquityFetchEvent();

	@Generated
	@Selector("platform")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object platform();

	@Generated
	@Selector("presentErrorWithMessageText:informativeText:")
	public native void presentErrorWithMessageTextInformativeText(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("primaryInstrumentsServer")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object primaryInstrumentsServer();

	@Generated
	@Selector("proxiedDevices")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object proxiedDevices();

	@Generated
	@Selector("recordedFramesBacktraceRecordingDylibPath")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object recordedFramesBacktraceRecordingDylibPath();

	@Generated
	@Selector("recordedFramesLibdispatchIntrospectionDylibPath")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object recordedFramesLibdispatchIntrospectionDylibPath();

	@Generated
	@Selector("renameDevice:")
	public native void renameDevice(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("restoreContentsAndSettingsFrom:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object restoreContentsAndSettingsFrom(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("runExecutableAtPath:withArguments:environment:options:terminationHandler:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object runExecutableAtPathWithArgumentsEnvironmentOptionsTerminationHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1, @Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3, @Mapped(ObjCObjectMapper.class) Object arg4,
			@Mapped(ObjCObjectMapper.class) Object arg5);

	@Generated
	@Selector("setAssetProvider:")
	public native void setAssetProvider(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("setDevice:")
	public native void setDevice(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("setDisplayOrder:")
	public native void setDisplayOrder(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("setName:")
	public native void setName(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("setSimulatorPID:")
	public native void setSimulatorPID(int arg1);

	@Generated
	@Selector("setXpcAttachServiceChannel:")
	public native void setXpcAttachServiceChannel(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("setXpcProxyAttachServiceChannel:")
	public native void setXpcProxyAttachServiceChannel(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("shouldPresentDeviceForBuildable:buildParameters:error:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object shouldPresentDeviceForBuildableBuildParametersError(
			@Mapped(ObjCObjectMapper.class) Object arg1, @Mapped(ObjCObjectMapper.class) Object arg2,
			Ptr<ObjCObject> arg3);

	@Generated
	@Selector("shouldProcessPath:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object shouldProcessPath(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("showCompanionUI")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object showCompanionUI();

	@Generated
	@Selector("shutDownDevice")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object shutDownDevice();

	@Generated
	@Selector("shutdown")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object shutdown();

	@Generated
	@Selector("simulateLocationWithLatitude:longitude:")
	public native void simulateLocationWithLatitudeLongitude(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("simulatorDirectoriesForAppName:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object simulatorDirectoriesForAppName(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("simulatorWithDevice:")
	public static native DVTiPhoneSimulator simulatorWithDevice(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("softwareVersion")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object softwareVersion();

	@Generated
	@Selector("spawnExecutableAtPath:withOptions:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object spawnExecutableAtPathWithOptions(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("spawnExecutableAtPath:withOptions:andTerminationHandler:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object spawnExecutableAtPathWithOptionsAndTerminationHandler(
			@Mapped(ObjCObjectMapper.class) Object arg1, @Mapped(ObjCObjectMapper.class) Object arg2,
			@Mapped(ObjCObjectMapper.class) Object arg3);

	@Generated
	@Selector("startAssetServerForApplicationAtPath:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object startAssetServerForApplicationAtPath(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("startUpDevice")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object startUpDevice();

	@Generated
	@Selector("startupState")
	public native long startupState();

	@Generated
	@Selector("stopDebuggingXPCServices:forPairedDevice:")
	public native void stopDebuggingXPCServicesForPairedDevice(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("stopLocationSimulation")
	public native void stopLocationSimulation();

	@Generated
	@Selector("supportedArchitectures")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object supportedArchitectures();

	@Generated
	@Selector("supportedLaunchOptions")
	public native long supportedLaunchOptions();

	@Generated
	@Selector("supportedSDKsForBuildable:buildParameters:error:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object supportedSDKsForBuildableBuildParametersError(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, Ptr<ObjCObject> arg3);

	@Generated
	@Selector("supportsApplicationDataUploading")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object supportsApplicationDataUploading();

	@Generated
	@Selector("supportsDisplayScaleOption")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object supportsDisplayScaleOption();

	@Generated
	@Selector("supportsFetchEvents")
	public native long supportsFetchEvents();

	@Generated
	@Selector("supportsLocationSimulation")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object supportsLocationSimulation();

	@Generated
	@Selector("supportsPGOReturningError:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object supportsPGOReturningError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("supportsRoutingCoverageFile")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object supportsRoutingCoverageFile();

	@Generated
	@Selector("supportsTestManagerDaemon")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object supportsTestManagerDaemon();

	@Generated
	@Selector("systemBasePath")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object systemBasePath();

	@Generated
	@Selector("taskForDeviceCommand:withArguments:error:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object taskForDeviceCommandWithArgumentsError(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2, Ptr<ObjCObject> arg3);

	@Generated
	@Selector("testArchitectureForBuildableProduct:withBuildParameters:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object testArchitectureForBuildableProductWithBuildParameters(
			@Mapped(ObjCObjectMapper.class) Object arg1, @Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("testHostPathForBuildableProduct:buildParameters:outError:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object testHostPathForBuildableProductBuildParametersOutError(
			@Mapped(ObjCObjectMapper.class) Object arg1, @Mapped(ObjCObjectMapper.class) Object arg2,
			Ptr<ObjCObject> arg3);

	@Generated
	@Selector("testingShouldAttachDebuggerWithHost:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object testingShouldAttachDebuggerWithHost(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("transferDirectionsFileToBundlePath:launchService:")
	public native void transferDirectionsFileToBundlePathLaunchService(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("uninstallApplicationWithBundleIdentifier:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object uninstallApplicationWithBundleIdentifier(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("uninstallApplicationWithBundleIdentifier:andOptions:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object uninstallApplicationWithBundleIdentifierAndOptions(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("uploadApplicationDataToBundlePath:launchService:")
	public native void uploadApplicationDataToBundlePathLaunchService(@Mapped(ObjCObjectMapper.class) Object arg1,
			@Mapped(ObjCObjectMapper.class) Object arg2);

	@Generated
	@Selector("xpcServiceObserved:withProcessIdentifier:requestedByProcess:options:")
	public native void xpcServiceObservedWithProcessIdentifierRequestedByProcessOptions(
			@Mapped(ObjCObjectMapper.class) Object arg1, int arg2, int arg3,
			@Mapped(ObjCObjectMapper.class) Object arg4);
}
