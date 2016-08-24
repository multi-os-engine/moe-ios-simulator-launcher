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
#import <Cocoa/Cocoa.h>
#import "Config.h"
#import "DevTools.h"
#include <sys/stat.h>

NSOperationQueue *moe_wfp_queue;
NSFileHandle *moe_stdout_fh;
NSFileHandle *moe_stderr_fh;
pid_t moe_app_pid = -1;
static BOOL moe_should_terminate = NO;

void termination_handler(int signum) {
    moe_should_terminate = YES;
}

void moe_main(Config *config);

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // Collect args
        NSMutableArray<NSString *> *args = [NSMutableArray array];
        for (int i = 1; i < argc; ++i) {
            [args addObject:[NSString stringWithUTF8String:argv[i]]];
        }

        // Read configuration
        Config *config = [[Config alloc] initWithArgs:args];

        // Create wait for pid queue
        moe_wfp_queue = [[NSOperationQueue alloc] init];

        moe_main(config);
    }
    return 0;
}

MOESimDevice *getSimDevice(NSUUID *udid) {
    NSArray<MOESimDevice *>* devices = [[MOESimDeviceSet defaultSet] devices];
    __block MOESimDevice *result;
    [devices enumerateObjectsUsingBlock:^(MOESimDevice * _Nonnull obj, NSUInteger idx, BOOL * _Nonnull stop) {
        if ([[obj UDID] isEqualTo:udid]) {
            result = obj;
            *stop = YES;
        }
    }];
    return result;
}

NSString *moe_mktemp(MOESimDevice *dev) {
    char *template = strdup([[dev devicePath] stringByAppendingPathComponent:@"tmp/XXXXXX"].UTF8String);
    mktemp(template);
    return [NSString stringWithCString:template encoding:NSASCIIStringEncoding];
}

NSFileHandle *moe_mkfifo(NSString *path, FILE *outFile) {
    NSString *parent = [path stringByDeletingLastPathComponent];
    NSFileManager *fileman = [NSFileManager defaultManager];
    if (![fileman fileExistsAtPath:parent isDirectory:NULL]) {
        NSError *error;
        BOOL succ = [fileman createDirectoryAtPath:parent
                       withIntermediateDirectories:YES
                                        attributes:nil
                                             error:&error];
        if (!succ) {
            NSLog(@"Failed to create directory at %@. %@", parent, error);
        }
    }

    int status = mkfifo(path.UTF8String, S_IRUSR | S_IWUSR);
    moe_runtime_check(status == 0, @"Failed to mkfifo at %@", path);

    int fd = open(path.UTF8String, O_RDONLY | O_NDELAY);
    moe_runtime_check(fd != -1, @"Failed to mkfifo at %@", path);

    NSFileHandle *fh = [[NSFileHandle alloc] initWithFileDescriptor:fd];
    [fh setReadabilityHandler:^(NSFileHandle * _Nonnull file) {
        NSData *data = [file availableData];
        if (!data) return;
        NSString *msg = [[NSString alloc] initWithData:data
                                              encoding:NSUTF8StringEncoding];
        fprintf(outFile, "%s", msg.UTF8String);
    }];
    return fh;
}

void moe_main(Config *config) {
    // Call shared application, otherwise [NSApp terminate:nil] won't work
    [NSApplication sharedApplication];

    // Verify config
    if (config.udid == nil && config.appPath == nil && config.printedHelp) {
        exit(0);
    }
    moe_runtime_check(config.udid != nil || [config printHelp], @"Error: simulator device UDID was not specified.");
    moe_runtime_check(config.appPath != nil || [config printHelp], @"Error: application was not specified.");

    // Error handling
    NSError *error;
    BOOL success;

    // Plugin manager
    MOEDVTPlugInManager *pluginManager = [MOEDVTPlugInManager defaultPlugInManager];
    success = [pluginManager scanForPlugIns:&error];
    moe_runtime_check(success, @"Failed to scan for plugins. %@", error);

    // Platform support
    success = [MOEDVTPlatform loadAllPlatformsReturningError:&error];
    moe_runtime_check(success, @"Failed to load platforms. %@", error);

    // Target device
    MOESimDevice *device = getSimDevice(config.udid);
    moe_runtime_check(device != nil, @"Failed to locate simulator with UDID %@", config.udid.UUIDString);

    // Check app MinimumOSVersion
    NSBundle *appBundle = [NSBundle bundleWithPath:config.appPath];
    NSString *appMinimumOSVersion = [appBundle infoDictionary][@"MinimumOSVersion"];
    if (appMinimumOSVersion != nil /* if min version is nil, hope for the best, fail later */) {
        NSString *deviceVersion = device.runtime.versionString;
        if ([appMinimumOSVersion compare:deviceVersion options:NSNumericSearch] == NSOrderedDescending) {
            moe_runtime_check(NO, @"Error: application requires iOS %@ but specified simulator is only iOS %@.", appMinimumOSVersion, deviceVersion);
        }
    }

    // Launch simulator application
    MOEDVTSimulatorApplication *simapp = [MOEDVTSimulatorApplication simulatorApplicationForDevice:device];
    success = [simapp launchWithError:&error andReadyCallback:^{
        [simapp sendStartSessionNotificationWithUserInfo:@{@"deviceUDID":config.udid.UUIDString}];

        // Force activate simulator app
        if (!config.dontActivate) {
            [[NSRunningApplication runningApplicationsWithBundleIdentifier:[simapp bundleIdentifier]] enumerateObjectsUsingBlock:^(NSRunningApplication * _Nonnull obj, NSUInteger idx, BOOL * _Nonnull stop) {
                [obj activateWithOptions:NSApplicationActivateIgnoringOtherApps];
            }];
        }

        // Wait for booted state
        NSDate *waitLimit = [NSDate dateWithTimeIntervalSinceNow:120.0];
        while ([device state] != MOESimDeviceStateBooted) {
            moe_runtime_check([[NSDate date] isLessThan:waitLimit], @"Waiting for booted state timeouted.");
            usleep(1000);
        }

        // Install the app
        MOEDVTFilePath *path = [MOEDVTFilePath filePathForPathString:config.appPath];
        MOEDVTFuture *installFuture = [device dvt_installApplicationAtPath:path];
        [installFuture waitUntilFinished];
        moe_runtime_check(![installFuture error], @"Failed to install application. %@", [installFuture error]);

        // Setup stdout forwarding
        NSString * stdout_path = moe_mktemp(device);
        moe_stdout_fh = moe_mkfifo(stdout_path, stdout);

        // Setup stderr forwarding
        NSString * stderr_path = moe_mktemp(device);
        moe_stderr_fh = moe_mkfifo(stderr_path, stderr);

        // Launch the app
        NSMutableDictionary *opts = [config launchOptions];
        [opts setObject:stdout_path forKey:@"stdout"];
        [opts setObject:stderr_path forKey:@"stderr"];
        MOEDVTFuture *launchFuture = [device dvt_launchApplicationWithBundleIdentifier:appBundle.bundleIdentifier
                                                                            andOptions:opts];
        [launchFuture waitUntilFinished];
        moe_runtime_check(![launchFuture error], @"Failed to launch application. %@", [launchFuture error]);
        NSNumber *launchedPid = [launchFuture result];
        moe_app_pid = launchedPid.intValue;

        // Wait for pid and terminate
        [moe_wfp_queue addOperationWithBlock:^{
            moe_wait_pid(moe_app_pid);
            dispatch_after(dispatch_time(DISPATCH_TIME_NOW, (int64_t)(0.5 * NSEC_PER_SEC)), dispatch_get_main_queue(), ^{
                moe_should_terminate = YES;
            });
        }];
    }];
    moe_runtime_check(success, @"Failed to launch simulator app. %@", error);

    // Setup sig handlers
    struct sigaction action;
    action.sa_handler = termination_handler;
    sigemptyset (&action.sa_mask);
    action.sa_flags = 0;
    sigaction(SIGINT, &action, NULL);
    sigaction(SIGTERM, &action, NULL);

    // Enter main loop
    while (!moe_should_terminate) {
        [[NSRunLoop mainRunLoop] runUntilDate:[NSDate dateWithTimeIntervalSinceNow:0.1]];
    }
    
    // Kill the launched app
    if (moe_app_pid != -1) {
        kill(moe_app_pid, SIGKILL);
    }
}
