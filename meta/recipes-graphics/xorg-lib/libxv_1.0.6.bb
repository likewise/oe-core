DESCRIPTION = "X11 Video extension library"

require xorg-lib-common.inc

LICENSE = "MIT-style"
LIC_FILES_CHKSUM = "file://COPYING;md5=916ffd3d79baef9fb56d2c2af28f93f2"

DEPENDS += "libxext videoproto"

PR = "r0"

XORG_PN = "libXv"