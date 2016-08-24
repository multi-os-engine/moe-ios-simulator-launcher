#!/bin/sh

#
# BUILD moe.ios.simulator.launcher PROJECT
#

set -e

qualifier="$1"
build_number="$2"
target_repo="$3"
repo_user="$4"
repo_pass="$5"

export MOE_MAVEN_ADDR=$target_repo

export MOE_IOS_SIMULATOR_LAUNCHER_BUILD_NUMBER=$build_number
export PUBLISH_TARGET_REPO_ADDR=$target_repo
export PUBLISH_TARGET_REPO_USER=$repo_user
export PUBLISH_TARGET_REPO_PASS=$repo_pass

xcodebuild -project simlauncher.xcodeproj -target simlauncher -configuration Release
mkdir -p "$target_repo/other"
cp build/Release/simlauncher "$target_repo/other/simlauncher"
