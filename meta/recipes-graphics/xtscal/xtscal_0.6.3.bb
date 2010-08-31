DESCRIPTION = "Touchscreen calibration utility"
HOMEPAGE = "http://gpe.linuxtogo.org"
BUGTRACKER = "http://bugs.linuxtogo.org"
LICENSE = "GPLv2 & GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f \
                    file://main.c;endline=10;md5=8721bcb08ae9f24e5fe4c82941873c87"

SECTION = "x11/base"

DEPENDS = "virtual/libx11 libxft libxcalibrate"

PR = "r12"

SRC_URI = "${GPE_MIRROR}/xtscal-${PV}.tar.bz2 \
           file://change-cross.patch;patch=1 \
           file://cleanup.patch;patch=1 \
           file://30xTs_Calibrate.sh"

inherit autotools

do_install_append() {
    install -d ${D}${sysconfdir}/X11/Xsession.d/
    install -m 0755 ${WORKDIR}/30xTs_Calibrate.sh ${D}${sysconfdir}/X11/Xsession.d/
}