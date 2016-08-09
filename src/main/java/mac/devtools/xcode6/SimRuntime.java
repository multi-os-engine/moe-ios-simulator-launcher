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
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.objc.ObjCObject;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;
import mac.NSObject;
import mac.foundation.NSArray;
import mac.foundation.NSBundle;
import mac.foundation.NSDictionary;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SimRuntime extends NSObject {
	static {
		NatJ.register();
	}

	@Generated
	protected SimRuntime(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("aliases")
	public native NSDictionary aliases();

	@Generated
	@Owned
	@Selector("alloc")
	public static native SimRuntime alloc();

	@Generated
	@Selector("available")
	public native boolean available();

	@Generated
	@Selector("buildVersionString")
	public native String buildVersionString();

	@Generated
	@Selector("bundle")
	public native NSBundle bundle();

	@Generated
	@Selector("compare:")
	public native long compare(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("createInitialContentPath:")
	public native void createInitialContentPath(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("createInitialContentPath:error:")
	public native boolean createInitialContentPathError(
			@Mapped(ObjCObjectMapper.class) Object arg1, Ptr<ObjCObject> arg2);

	@Generated
	@Selector("dvt_runtimeFromSDKRoot:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object dvt_runtimeFromSDKRoot(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("dyld_simPath")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dyld_simPath();

	@Generated
	@Selector("environment")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object environment();

	@Generated
	@Selector("environment_extra")
	public native NSDictionary environment_extra();

	@Generated
	@Selector("identifier")
	public native String identifier();

	@Generated
	@Selector("init")
	public native SimRuntime init();

	@Generated
	@Selector("initWithBundle:")
	public native SimRuntime initWithBundle(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("initWithPath:")
	public native SimRuntime initWithPath(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("isAvailableWithError:")
	public native boolean isAvailableWithError(Ptr<ObjCObject> arg1);

	@Generated
	@Selector("libLaunchHostHandle")
	public native VoidPtr libLaunchHostHandle();

	@Generated
	@Selector("maxHostVersion")
	public native int maxHostVersion();

	@Generated
	@Selector("minHostVersion")
	public native int minHostVersion();

	@Generated
	@Selector("name")
	public native String name();

	@Generated
	@Selector("platformPath")
	public native String platformPath();

	@Generated
	@Selector("platformRuntimeOverlay")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object platformRuntimeOverlay();

	@Generated
	@Selector("requiredHostServices")
	public native NSDictionary requiredHostServices();

	@Generated
	@Selector("root")
	public native String root();

	@Generated
	@Selector("sampleContentPath")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object sampleContentPath();

	@Generated
	@Selector("setAliases:")
	public native void setAliases(NSDictionary value);

	@Generated
	@Selector("setBuildVersionString:")
	public native void setBuildVersionString(String value);

	@Generated
	@Selector("setBundle:")
	public native void setBundle(NSBundle value);

	@Generated
	@Selector("setEnvironment_extra:")
	public native void setEnvironment_extra(NSDictionary value);

	@Generated
	@Selector("setIdentifier:")
	public native void setIdentifier(String value);

	@Generated
	@Selector("setLibLaunchHostHandle:")
	public native void setLibLaunchHostHandle(VoidPtr value);

	@Generated
	@Selector("setMaxHostVersion:")
	public native void setMaxHostVersion(int value);

	@Generated
	@Selector("setMinHostVersion:")
	public native void setMinHostVersion(int value);

	@Generated
	@Selector("setName:")
	public native void setName(String value);

	@Generated
	@Selector("setPlatformPath:")
	public native void setPlatformPath(String value);

	@Generated
	@Selector("setRequiredHostServices:")
	public native void setRequiredHostServices(NSDictionary value);

	@Generated
	@Selector("setRoot:")
	public native void setRoot(String value);

	@Generated
	@Selector("setSupportedFeatures:")
	public native void setSupportedFeatures(NSDictionary value);

	@Generated
	@Selector("setSupportedFeaturesConditionalOnDeviceType:")
	public native void setSupportedFeaturesConditionalOnDeviceType(
			NSDictionary value);

	@Generated
	@Selector("setSupportedProductFamilyIDs:")
	public native void setSupportedProductFamilyIDs(NSArray value);

	@Generated
	@Selector("setVersion:")
	public native void setVersion(int value);

	@Generated
	@Selector("setVersionString:")
	public native void setVersionString(String value);

	@Generated
	@Selector("supportedFeatures")
	public native NSDictionary supportedFeatures();

	@Generated
	@Selector("supportedFeaturesConditionalOnDeviceType")
	public native NSDictionary supportedFeaturesConditionalOnDeviceType();

	@Generated
	@Selector("supportedProductFamilyIDs")
	public native NSArray supportedProductFamilyIDs();

	@Generated
	@Selector("supportedRuntimes")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object supportedRuntimes();

	@Generated
	@Selector("supportedRuntimesByAlias")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object supportedRuntimesByAlias();

	@Generated
	@Selector("supportedRuntimesByIdentifier")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object supportedRuntimesByIdentifier();

	@Generated
	@Selector("supportsDevice:")
	public native boolean supportsDevice(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("supportsDeviceType:")
	public native boolean supportsDeviceType(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("supportsFeature:")
	public native boolean supportsFeature(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("supportsFeatureConditionally:")
	public native boolean supportsFeatureConditionally(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("verifyRuntime")
	public native boolean verifyRuntime();

	@Generated
	@Selector("version")
	public native int version();

	@Generated
	@Selector("versionString")
	public native String versionString();
}
