SUMMARY = "XvMC: X Video Motion Compensation extension library"

DESCRIPTION = "XvMC extends the X Video extension (Xv) and enables \
hardware rendered motion compensation support."

require xorg-lib-common.inc

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=0a207f08d4961489c55046c9a5e500da \
                    file://src/XvMCWrapper.c;endline=26;md5=5151daa8172a3f1bb0cb0e0ff157d9de"

DEPENDS += "libxext libxv videoproto"

PR = "r0"
PE = "1"

XORG_PN = "libXvMC"

SRC_URI[md5sum] = "bfc7524646f890dfc30dea1d676004a3"
SRC_URI[sha256sum] = "3dda80e9c71fd14a14f93279c6f661703c5c1c43d104a5db0842377bdf0c3392"
