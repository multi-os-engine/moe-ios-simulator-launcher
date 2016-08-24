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

#import "Config.h"

#include <sys/event.h>

void moe_runtime_check(BOOL condition, NSString * _Nonnull fmt, ...) {
    if (condition) return;
    va_list list;
    va_start(list, fmt);
    NSString *msg = [[NSString alloc] initWithFormat:fmt arguments:list];
    va_end(list);
    fprintf(stderr, "%s\n", msg.UTF8String);
    exit(1);
}

void moe_wait_pid(pid_t pid) {
    int kq = kqueue();
    moe_runtime_check(kq != -1, @"Error with kqueue");

    struct kevent ke;
    EV_SET(&ke, pid, EVFILT_PROC, EV_ADD, NOTE_EXIT, 0, NULL);

    int i = kevent(kq, &ke, 1, NULL, 0, NULL);
    moe_runtime_check(i != -1, @"Error with kevent");

    while (1) {
        memset(&ke, 0x00, sizeof(struct kevent));
        i = kevent(kq, NULL, 0, &ke, 1, NULL);
        moe_runtime_check(i != -1, @"Error with kevent");
        if (ke.fflags & NOTE_EXIT) break;
        usleep(100000);
    }

    EV_SET(&ke, pid, EVFILT_PROC, EV_DELETE, NOTE_EXIT, 0, NULL);
}

@implementation Config

- (instancetype _Nonnull)initWithArgs:(NSArray<NSString *> * _Nonnull)args {
    self = [super init];
    if (self) {
        _args = [NSMutableArray array];
        _env = [NSMutableDictionary dictionary];
        [args enumerateObjectsUsingBlock:^(NSString * _Nonnull obj, NSUInteger idx, BOOL * _Nonnull stop) {
            [self setFromArg:obj];
        }];
    }
    return self;
}

- (void)setFromArg:(NSString * _Nonnull)arg {
    NSString * _Nullable value = nil;
    if (arg == nil) {
        return;

    } else if ([self matchesShortForm:@"-u" orLongForm:@"--udid" source:arg remaining:&value]) {
        _udid = [[NSUUID alloc] initWithUUIDString:value];
        moe_runtime_check(_udid != nil, @"Invalid UDID string '%@'.", value);

    } else if ([self matchesShortForm:@"-a" orLongForm:@"--app-path" source:arg remaining:&value]) {
        _appPath = value;
        NSFileManager *fileMan = [NSFileManager defaultManager];
        moe_runtime_check([fileMan fileExistsAtPath:_appPath], @"Invalid application '%@'.", value);

    } else if ([self matchesShortForm:@"-x" orLongForm:@"--launch-arg" source:arg remaining:&value]) {
        if (!value) return;
        [_args addObject:value];

    } else if ([self matchesShortForm:@"-e" orLongForm:@"--env" source:arg remaining:&value]) {
        if (!value) return;
        const NSRange range = [value rangeOfString:@"="];
        if (range.location == NSNotFound) {
            [_env setObject:@"" forKey:value];
        } else {
            [_env setObject:[value substringFromIndex:range.location + range.length]
                     forKey:[value substringToIndex:range.location]];
        }

    } else if ([self matchesShortForm:@"-d" orLongForm:@"--debug" source:arg remaining:&value]) {
        if (_debug) return;
        _debug = YES;
        NSScanner *scanner = [NSScanner scannerWithString:value];
        int port;
        moe_runtime_check([scanner scanInt:&port], @"Failed to scan debug port number from '%@'.", value);
        moe_runtime_check([scanner isAtEnd], @"Failed to scan debug port number from '%@'.", value);
        [_args insertObject:[NSString stringWithFormat:@"-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=%i", port] atIndex:0];

    } else if ([self matchesShortForm:@"-noact" orLongForm:@"--dont-activate" source:arg remaining:&value]) {
        _dontActivate = YES;

    } else if ([self matchesShortForm:@"-wdeb" orLongForm:@"--wait-for-debugger" source:arg remaining:&value]) {
        _waitForDebugger = YES;

    } else if ([self matchesShortForm:@"-h" orLongForm:@"--help" source:arg remaining:&value]) {
        [self printHelp];

    } else {
        NSLog(@"Unrecognized launcher parameter: %@", arg);
    }
}

- (BOOL)printHelp {
    if (_printedHelp) return NO;
    _printedHelp = YES;
    printf("Help\n"
           "------------------\n"
           "-u,--udid\n"
           "    Set device UDID to attach to. \n"
           "        Example: --udid=afb5fab15af51b6afba1fba65fb1a6af56b16af1\n"
           "\n"
           "-a,--app-path\n"
           "    Set the application to run. \n"
           "        Example: --app-path=/my/file/superapp.app\n"
           "\n"
           "-x,--launch-arg\n"
           "    Pass a value as launch argument, pass this option multiple times to specify \n"
           "    multiple values. \n"
           "        Example: -x=my_arg\n"
           "\n"
           "-e,--env\n"
           "    Pass a key-value pair as an env variable, pass this option multiple times to \n"
           "    specify multiple key-values pairs. \n"
           "        Example: -e=key=value\n"
           "\n"
           "-d,--debug\n"
           "    Start the app with the JDWP debugger on the specified port, and creates a \n"
           "    proxy server for it. \n"
           "        Example: --debug=5005\n"
           "\n"
           "-noact,--dont-activate\n"
           "    Do not activate (aka. bring to foreground) the simulator after it launched \n"
           "    the app. \n"
           "        Example: --dont-activate\n"
           "\n"
           "-wdeb,--wait-for-debugger\n"
           "    Launch the app, but don't start it, wait for a debugger to attach. \n"
           "        Example: -wdeb\n");
    return NO;
}

- (BOOL)matchesShortForm:(NSString * _Nonnull)sForm
              orLongForm:(NSString * _Nonnull)lForm
                  source:(NSString * _Nonnull)arg
               remaining:(NSString * __strong _Nullable * _Nonnull)value {
    if ([self matchesForm:sForm source:arg remaining:value])
        return YES;
    if ([self matchesForm:lForm source:arg remaining:value])
        return YES;
    return NO;
}

- (BOOL)matchesForm:(NSString *)form
             source:(NSString *)arg
          remaining:(NSString * __strong *)value {
    if ([arg hasPrefix:form]) {
        if ([arg isEqualToString:form]) {
            *value = nil;
            return YES;
        } else if ([arg hasPrefix:[NSString stringWithFormat:@"%@=", form]]) {
            *value = [arg substringFromIndex:form.length + 1];
            return YES;
        } else {
            return NO;
        }
    } else {
        return NO;
    }
}

- (NSMutableDictionary * _Nonnull)launchOptions {
    NSMutableDictionary *opts = [NSMutableDictionary dictionary];

    [opts setObject:[_args copy] forKey:@"arguments"];

    NSMutableDictionary *envs = [_env mutableCopy];
    [envs setObject:@"YES" forKey:@"NSUnbufferedIO"];
    [opts setObject:envs forKey:@"environment"];
    [opts setObject:_waitForDebugger ? @"1" : @"0" forKey:@"wait_for_debugger"];
    return opts;
}

@end
