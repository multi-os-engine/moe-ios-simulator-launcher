# iOS Simulator Launcher

## Options

### -u, --udid

Set device UDID to attach to.

`Example: --udid=afb5fab15af51b6afba1fba65fb1a6af56b16af1`

### -a, --app-path

Set the application to run.

`Example: --app-path=/my/file/superapp.app`

### -l, --list

Print the list the connected devices.

### -x, --launch-arg

Pass a value as launch argument, pass this option multiple times to specify multiple values.

`Example: -x=my_arg`

### -e, --env

Pass a key-value pair as an env variable, pass this option multiple times to specify multiple key-values pairs.

`Example: -e=key=value`

### -d, --debug

Start the app with the JDWP debugger on the specified port, and creates a proxy server for it.

`Example: --debug=5005`

### -noact, --dont-activate

Do not activate (aka. bring to foreground) the simulator after it launched the app.

`Example: --dont-activate`

### -wdeb, --wait-for-debugger

Launch the app, but don't start it, wait for a debugger to attach.

`Example: -wdeb`
