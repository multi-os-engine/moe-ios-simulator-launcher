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
import org.moe.natj.objc.Class;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;
import mac.NSObject;
import mac.coregraphics.struct.CGSize;
import mac.foundation.NSArray;
import mac.foundation.NSBundle;
import mac.foundation.NSDictionary;

@Generated
@Runtime(ObjCRuntime.class)
@ObjCClassBinding
public class SimDeviceType extends NSObject {
	static {
		NatJ.register();
	}

	@Generated
	protected SimDeviceType(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("aliases")
	public native NSDictionary aliases();

	@Generated
	@Owned
	@Selector("alloc")
	public static native SimDeviceType alloc();

	@Generated
	@Selector("bundle")
	public native NSBundle bundle();

	@Generated
	@Selector("capabilities")
	public native NSDictionary capabilities();

	@Generated
	@Selector("compare:")
	public native long compare(@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("deviceClass")
	public native Class deviceClass();

	@Generated
	@Selector("dvt_has64BitArch")
	public native boolean dvt_has64BitArch();

	@Generated
	@Selector("dvt_latestRuntime")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_latestRuntime();

	@Generated
	@Selector("dvt_supportedArchStrings")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_supportedArchStrings();

	@Generated
	@Selector("dvt_supportedArchs")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object dvt_supportedArchs();

	@Generated
	@Selector("environment")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object environment();

	@Generated
	@Selector("environmentForRuntime:")
	@MappedReturn(ObjCObjectMapper.class)
	public native Object environmentForRuntime(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("environment_extra")
	public native NSDictionary environment_extra();

	@Generated
	@Selector("identifier")
	public native String identifier();

	@Generated
	@Selector("init")
	public native SimDeviceType init();

	@Generated
	@Selector("initWithBundle:")
	public native SimDeviceType initWithBundle(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("initWithPath:")
	public native SimDeviceType initWithPath(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("mainScreenDPI")
	@ByValue
	public native CGSize mainScreenDPI();

	@Generated
	@Selector("mainScreenScale")
	public native float mainScreenScale();

	@Generated
	@Selector("mainScreenSize")
	@ByValue
	public native CGSize mainScreenSize();

	@Generated
	@Selector("maxRuntimeVersion")
	public native int maxRuntimeVersion();

	@Generated
	@Selector("minRuntimeVersion")
	public native int minRuntimeVersion();

	@Generated
	@Selector("modelIdentifier")
	public native String modelIdentifier();

	@Generated
	@Selector("name")
	public native String name();

	@Generated
	@Selector("productClass")
	public native String productClass();

	@Generated
	@Selector("productFamily")
	public native String productFamily();

	@Generated
	@Selector("productFamilyID")
	public native int productFamilyID();

	@Generated
	@Selector("setAliases:")
	public native void setAliases(NSDictionary value);

	@Generated
	@Selector("setBundle:")
	public native void setBundle(NSBundle value);

	@Generated
	@Selector("setCapabilities:")
	public native void setCapabilities(NSDictionary value);

	@Generated
	@Selector("setEnvironment_extra:")
	public native void setEnvironment_extra(NSDictionary value);

	@Generated
	@Selector("setIdentifier:")
	public native void setIdentifier(String value);

	@Generated
	@Selector("setMainScreenDPI:")
	public native void setMainScreenDPI(@ByValue CGSize value);

	@Generated
	@Selector("setMainScreenScale:")
	public native void setMainScreenScale(float value);

	@Generated
	@Selector("setMainScreenSize:")
	public native void setMainScreenSize(@ByValue CGSize value);

	@Generated
	@Selector("setMaxRuntimeVersion:")
	public native void setMaxRuntimeVersion(int value);

	@Generated
	@Selector("setMinRuntimeVersion:")
	public native void setMinRuntimeVersion(int value);

	@Generated
	@Selector("setModelIdentifier:")
	public native void setModelIdentifier(String value);

	@Generated
	@Selector("setName:")
	public native void setName(String value);

	@Generated
	@Selector("setProductClass:")
	public native void setProductClass(String value);

	@Generated
	@Selector("setSpringBoardConfigName:")
	public native void setSpringBoardConfigName(String value);

	@Generated
	@Selector("setSupportedArchs:")
	public native void setSupportedArchs(NSArray value);

	@Generated
	@Selector("setSupportedFeatures:")
	public native void setSupportedFeatures(NSDictionary value);

	@Generated
	@Selector("setSupportedFeaturesConditionalOnRuntime:")
	public native void setSupportedFeaturesConditionalOnRuntime(
			NSDictionary value);

	@Generated
	@Selector("setSupportedProductFamilyIDs:")
	public native void setSupportedProductFamilyIDs(NSArray value);

	@Generated
	@Selector("springBoardConfigName")
	public native String springBoardConfigName();

	@Generated
	@Selector("supportedArchs")
	public native NSArray supportedArchs();

	@Generated
	@Selector("supportedDeviceTypes")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object supportedDeviceTypes();

	@Generated
	@Selector("supportedDeviceTypesByAlias")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object supportedDeviceTypesByAlias();

	@Generated
	@Selector("supportedDeviceTypesByIdentifier")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object supportedDeviceTypesByIdentifier();

	@Generated
	@Selector("supportedDeviceTypesByName")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object supportedDeviceTypesByName();

	@Generated
	@Selector("supportedDevices")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object supportedDevices();

	@Generated
	@Selector("supportedFeatures")
	public native NSDictionary supportedFeatures();

	@Generated
	@Selector("supportedFeaturesConditionalOnRuntime")
	public native NSDictionary supportedFeaturesConditionalOnRuntime();

	@Generated
	@Selector("supportedProductFamilyIDs")
	public native NSArray supportedProductFamilyIDs();

	@Generated
	@Selector("supportsFeature:")
	public native boolean supportsFeature(
			@Mapped(ObjCObjectMapper.class) Object arg1);

	@Generated
	@Selector("supportsFeatureConditionally:")
	public native boolean supportsFeatureConditionally(
			@Mapped(ObjCObjectMapper.class) Object arg1);
}
