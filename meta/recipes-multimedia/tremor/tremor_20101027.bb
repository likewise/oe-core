DESCRIPTION = "tremor is a fixed point implementation of the vorbis codec."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=db1b7a668b2a6f47b2af88fb008ad555 \
                    file://os.h;beginline=3;endline=14;md5=5c0af5e1bedef3ce8178c89f48cd6f1f"
DEPENDS = "libogg"
SRCDATE = "${PV}"
PR = "r0"

SRC_URI = "svn://svn.xiph.org/trunk;module=Tremor;rev=17572;proto=http"

S = "${WORKDIR}/Tremor"

inherit autotools

EXTRA_OECONF=" --enable-shared --disable-rpath  "

ARM_INSTRUCTION_SET = "arm"