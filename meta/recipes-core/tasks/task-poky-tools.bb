#
# Copyright (C) 2008 OpenedHand Ltd.
#

DESCRIPTION = "Tools tasks for Poky"
LICENSE = "MIT"
PR = "r6"

PACKAGES = "\
    task-poky-tools-debug \
    task-poky-tools-debug-dbg \
    task-poky-tools-debug-dev \
    task-poky-tools-profile \
    task-poky-tools-profile-dbg \
    task-poky-tools-profile-dev \
    task-poky-tools-testapps \
    task-poky-tools-testapps-dbg \
    task-poky-tools-testapps-dev \
    "

PACKAGE_ARCH = "${MACHINE_ARCH}"

ALLOW_EMPTY = "1"

# kexec-tools doesn't work on Mips
KEXECTOOLS ?= "kexec-tools"
KEXECTOOLS_mips ?= ""
KEXECTOOLS_mipsel ?= ""
KEXECTOOLS_powerpc ?= ""

RDEPENDS_task-poky-tools-debug = "\
    gdb \
    gdbserver \
    tcf-agent \
    strace"

RDEPENDS_task-poky-tools-profile = "\
    oprofile \
    oprofileui-server \
    powertop \
    latencytop \
    lttng-control \
    lttng-viewer"

RRECOMMENDS_task-poky-tools-profile = "\
    perf \
    trace-cmd \
    kernel-module-oprofile"

#    exmap-console
#    exmap-server

# At present we only build lttng-ust on
# qemux86/qemux86-64/qemuppc/emenlow/netbook since upstream liburcu
# (which is required by lttng-ust) may not build on other platforms, like
# MIPS and qemu ARMv5te that poky uses now.
RDEPENDS_task-poky-tools-profile_append_qemux86 = " valgrind lttng-ust"
RDEPENDS_task-poky-tools-profile_append_qemux86-64 = " lttng-ust"
RDEPENDS_task-poky-tools-profile_append_qemuppc = " lttng-ust"
RDEPENDS_task-poky-tools-profile_append_emenlow = " lttng-ust"
RDEPENDS_task-poky-tools-profile_append_netbook = " lttng-ust"

RDEPENDS_task-poky-tools-testapps = "\
    blktool \
    tslib-calibrate \
    tslib-tests \
    lrzsz \
    ${KEXECTOOLS} \
    alsa-utils-amixer \
    alsa-utils-aplay \
    owl-video \
    gst-meta-video \
    gst-meta-audio \
    xrestop \
    xwininfo \
    xprop \
    xvideo-tests"