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

// Check for condition
void moe_runtime_check(BOOL condition, NSString * _Nonnull fmt, ...);

// Wait for pid to exit
void moe_wait_pid(pid_t pid);

// Launcher configuration
@interface Config : NSObject

// Initialize with arguments
- (instancetype _Nonnull)initWithArgs:(NSArray<NSString *> * _Nonnull)args;

// Print help
- (BOOL)printHelp;

// Get launcher options
- (NSMutableDictionary * _Nonnull)launchOptions;

// Target device UDID
@property NSUUID * _Nullable udid;

// Path to the application
@property NSString * _Nullable appPath;

// Arguments to pass to the simulated app
@property NSMutableArray * _Nonnull args;

// Environmental variables to pass to the simulated app
@property NSMutableDictionary * _Nonnull env;

// Launch app with JDWP
@property (getter=isDebug) BOOL debug;

// Don't activate the simulator app
@property BOOL dontActivate;

// Wait for lldb to attach
@property BOOL waitForDebugger;

// Help was printed
@property BOOL printedHelp;
@end
