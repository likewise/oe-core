DESCRIPTION = "Touchscreen calibration client library"

require xorg-lib-common.inc

LICENSE = "MIT-style"
LIC_FILES_CHKSUM = "file://xcalibrate.h;endline=21;md5=fa572df6439f0f235f2612f370f153d7 \
                    file://xcalibrate.c;endline=21;md5=fa572df6439f0f235f2612f370f153d7"

DEPENDS = "virtual/libx11 calibrateproto libxext"

PV = "0.0+git${SRCPV}"
PR = "r0"

SRC_URI = "git://anongit.freedesktop.org/git/xorg/lib/libXCalibrate;protocol=git \
           file://fix-xcb.patch"

S = "${WORKDIR}/git"

FILES_${PN}-locale += "${datadir}/X11/locale"