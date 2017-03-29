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

#import "DevTools.h"
#import "Config.h"
#include <dlfcn.h>

struct _moe_dt_class {};

Class DTiPhoneSimulatorSession;
Class SimServiceContext;
Class SimDeviceSet;
Class SimDevice;
Class SimRuntime;
Class DVTSimulatorApplication;
Class DVTPlatform;
Class DVTPlugInManager;
Class DVTDeveloperPaths;
Class DVTFilePath;
Class DVTFuture;

void* moe_load_devtools_bundle(NSString * _Nonnull subpath);

void moe_init_devtools() {
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        void *dvtfoundation = moe_load_devtools_bundle(@"SharedFrameworks/DVTFoundation.framework/DVTFoundation");
        moe_load_devtools_bundle(@"SharedFrameworks/DVTDeviceFoundation.framework/DVTDeviceFoundation");
        moe_load_devtools_bundle(@"SharedFrameworks/DTDeviceKitBase.framework/DTDeviceKitBase");
        moe_load_devtools_bundle(@"SharedFrameworks/DVTiPhoneSimulatorRemoteClient.framework/DVTiPhoneSimulatorRemoteClient");
        moe_load_devtools_bundle(@"Developer/Library/PrivateFrameworks/CoreSimulator.framework/CoreSimulator");

        DTiPhoneSimulatorSession = NSClassFromString(@"DTiPhoneSimulatorSession");
        SimServiceContext = NSClassFromString(@"SimServiceContext");
        SimDeviceSet = NSClassFromString(@"SimDeviceSet");
        SimDevice = NSClassFromString(@"SimDevice");
        SimRuntime = NSClassFromString(@"SimRuntime");
        DVTSimulatorApplication = NSClassFromString(@"DVTSimulatorApplication");
        DVTPlatform = NSClassFromString(@"DVTPlatform");
        DVTPlugInManager = NSClassFromString(@"DVTPlugInManager");
        DVTDeveloperPaths = NSClassFromString(@"DVTDeveloperPaths");
        DVTFilePath = NSClassFromString(@"DVTFilePath");
        DVTFuture = NSClassFromString(@"DVTFuture");

        ((void(*)())dlsym(dvtfoundation, "DVTInitializeSharedFrameworks"))();
        [DVTDeveloperPaths initializeApplicationDirectoryName:@"Xcode"];
    });
}

NSString* moe_get_xcode_contents_path() {
    static NSString *xccontents;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{ @autoreleasepool {
        // Create xcode-select -p task
        NSTask *task = [[NSTask alloc] init];
        task.launchPath = @"/usr/bin/xcode-select";
        task.arguments = @[@"-p"];

        // Create output and error buffers
        NSMutableString *outputBuffer = [[NSMutableString alloc] initWithCapacity:16 * 1024];
        NSMutableString *errorBuffer = [[NSMutableString alloc] initWithCapacity:16 * 1024];

        // Create pipes
        NSPipe *sin = [NSPipe pipe];
        NSPipe *sout = [NSPipe pipe];
        NSPipe *serr = [NSPipe pipe];
        task.standardInput = sin;
        task.standardOutput = sout;
        task.standardError = serr;

        // Read output
        [[sout fileHandleForReading] setReadabilityHandler:^(NSFileHandle * _Nonnull file) {
            NSData *data = [file availableData];
            if (!data) return;
            NSString *msg = [[NSString alloc] initWithData:data
                                                  encoding:NSUTF8StringEncoding];
            [outputBuffer appendString:msg];
        }];

        // Read error
        [[serr fileHandleForReading] setReadabilityHandler:^(NSFileHandle * _Nonnull file) {
            NSData *data = [file availableData];
            if (!data) return;
            NSString *msg = [[NSString alloc] initWithData:data
                                                  encoding:NSUTF8StringEncoding];
            [errorBuffer appendString:msg];
        }];

        // Launch task
        [task launch];

        // Wait for completion
        while ([task isRunning]) {
            [[NSRunLoop mainRunLoop] runUntilDate:[NSDate dateWithTimeIntervalSinceNow:0.1]];
        }

        // Check success
        moe_runtime_check(task.terminationStatus == 0, @"Xcode-select failed. %@", errorBuffer);

        // Get contents path
        xccontents = [[outputBuffer stringByTrimmingCharactersInSet:
                       [NSCharacterSet whitespaceAndNewlineCharacterSet]]
                      stringByDeletingLastPathComponent];
    } });
    return xccontents;
}

void* moe_load_devtools_bundle(NSString * _Nonnull subpath) {
    NSString *path = [moe_get_xcode_contents_path() stringByAppendingPathComponent:subpath];
    if (![[NSFileManager defaultManager] fileExistsAtPath:path]) {
        NSLog(@"WARNING: Bundle is not present at path: %@", path);
        return nil;
    }
    void* fw = dlopen(path.UTF8String, RTLD_NOW | RTLD_GLOBAL);
    if (!fw) {
        NSLog(@"ERROR: %s", dlerror());
        abort();
    }
    return fw;
}

#define DT_BRIDGE(__name) MOE ## __name \
+ (void)initialize { \
if (self == [MOE ## __name class]) { \
moe_init_devtools(); \
} \
} \
+ (instancetype)alloc { \
return [__name alloc]; \
}

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wincomplete-implementation"

@implementation DT_BRIDGE(DTiPhoneSimulatorSession)
@end

@implementation DT_BRIDGE(SimServiceContext)
+ (MOESimServiceContext *)sharedServiceContext {
    return [SimServiceContext sharedServiceContext];
}
+ (MOESimServiceContext *)sharedServiceContextForDeveloperDir:(NSString *)dir error:(NSError * __autoreleasing *)error {
    return [SimServiceContext sharedServiceContextForDeveloperDir:dir error:error];
}
@end

@implementation DT_BRIDGE(SimDeviceSet)
+ (id)defaultSet {
    return [SimDeviceSet defaultSet];
}
@end

@implementation DT_BRIDGE(SimDevice)
@end

@implementation DT_BRIDGE(SimRuntime)
@end

@implementation DT_BRIDGE(DVTSimulatorApplication)
+ (MOEDVTSimulatorApplication *)simulatorApplicationForDevice:(MOESimDevice *)device {
    return [DVTSimulatorApplication simulatorApplicationForDevice:device];
}
@end

@implementation DT_BRIDGE(DVTPlatform)
+ (id)allPlatforms {
    return [DVTPlatform allPlatforms];
}

+ (BOOL)loadAllPlatformsReturningError:(NSError *__autoreleasing *)error {
    return [DVTPlatform loadAllPlatformsReturningError:error];
}
@end

@implementation DT_BRIDGE(DVTPlugInManager)
+ (MOEDVTPlugInManager *)defaultPlugInManager {
    return [DVTPlugInManager defaultPlugInManager];
}
@end

@implementation DT_BRIDGE(DVTDeveloperPaths)
+ (void)initializeApplicationDirectoryName:(NSString *)name {
    return [DVTDeveloperPaths initializeApplicationDirectoryName:name];
}
+ (instancetype)defaultPaths {
    return [DVTDeveloperPaths defaultPaths];
}
@end

@implementation DT_BRIDGE(DVTFilePath)
+ (MOEDVTFilePath *)filePathForPathString:(NSString *)path {
    return [DVTFilePath filePathForPathString:path];
}
@end

@implementation DT_BRIDGE(DVTFuture)
@end

#pragma clang diagnostic pop
