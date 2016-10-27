/*
 Copyright (C) 2016 Migeran

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

#import <Foundation/Foundation.h>

#define DT_INTERFACE(__name) MOE ## __name

@class MOESimDevice;
@class MOESimDeviceSet;
@class MOEDVTFilePath;
@class MOEDVTFuture;
@class MOESimRuntime;

@interface DT_INTERFACE(DTiPhoneSimulatorSession) : NSObject
@end

@interface DT_INTERFACE(SimServiceContext) : NSObject
+ (MOESimServiceContext *)sharedServiceContext;
+ (MOESimServiceContext *)sharedServiceContextForDeveloperDir:(NSString *)dir error:(NSError * __autoreleasing *)error;
- (MOESimDeviceSet *)defaultDeviceSetWithError:(NSError * __autoreleasing *)error;
@end

@interface DT_INTERFACE(SimDeviceSet) : NSObject
+ (MOESimDeviceSet *)defaultSet;
- (NSArray<MOESimDevice *>*)devices;
@end

typedef NS_ENUM(NSUInteger, MOESimDeviceState) {
    MOESimDeviceStateCreating = 0,
    MOESimDeviceStateShutdown = 1,
    MOESimDeviceStateBooting = 2,
    MOESimDeviceStateBooted = 3,
};

@interface DT_INTERFACE(SimDevice) : NSObject
- (NSUUID *)UDID;
- (MOEDVTFuture *)dvt_installApplicationAtPath:(MOEDVTFilePath *)path;
- (MOEDVTFuture *)dvt_launchApplicationWithBundleIdentifier:(NSString *)app andOptions:(NSDictionary *)options;
- (NSString *)devicePath;
- (NSString *)stateString;
- (MOESimDeviceState)state;
- (MOESimRuntime *)runtime;
@end

@interface DT_INTERFACE(SimRuntime) : NSObject
- (NSString *)versionString;
@end

@interface DT_INTERFACE(DVTSimulatorApplication) : NSObject
+ (MOEDVTSimulatorApplication*)simulatorApplicationForDevice:(MOESimDevice *)device;
- (BOOL)launchWithError:(NSError * __autoreleasing *)error andReadyCallback:(void (^)())cb;
- (void)sendStartSessionNotificationWithUserInfo:(NSDictionary *)userInfo;
- (NSString *)bundleIdentifier;
@end

@interface DT_INTERFACE(DVTPlatform) : NSObject
+ (id)allPlatforms;
+ (BOOL)loadAllPlatformsReturningError:(NSError * __autoreleasing *)error;
@end

@interface DT_INTERFACE(DVTPlugInManager) : NSObject
+ (MOEDVTPlugInManager *)defaultPlugInManager;
- (BOOL)scanForPlugIns:(NSError * __autoreleasing *)error;
@end

@interface DT_INTERFACE(DVTDeveloperPaths) : NSObject
+ (void)initializeApplicationDirectoryName:(NSString *)name;
+ (instancetype)defaultPaths;
- (MOEDVTFilePath *)developerDirectory;
@end

@interface DT_INTERFACE(DVTFilePath) : NSObject
+ (MOEDVTFilePath *)filePathForPathString:(NSString *)path;
- (NSString *)pathString;
@end

@interface DT_INTERFACE(DVTFuture) : NSObject
- (NSUInteger)waitUntilFinished;
- (id)result;
- (NSError *)error;
@end
