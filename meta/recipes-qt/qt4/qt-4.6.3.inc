LICENSE = "LGPLv2.1 | GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=fbc093901857fcd118f065f900982c24 \
                    file://LICENSE.GPL3;md5=babc5b6b77441da277f5c06b2e547720 \
                    file://LGPL_EXCEPTION.txt;md5=411080a56ff917a5a1aa08c98acae354"

SRC_URI = "http://get.qt.nokia.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://0001-cross-compile.patch \
           file://0002-fix-resinit-declaration.patch \
           file://0004-no-qmake.patch \
           file://0006-freetype-host-includes.patch \
           file://0008-qt-lib-infix.patch \
           file://0009-support-2bpp.patch \
           file://0010-no-simpledecoration-example.patch \
           file://fix-config-tests.patch \
           file://qt-config.patch \
           file://g++.conf \
           file://linux.conf \
           file://hack-out-pg_config.patch \
           "

S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

do_configure_prepend() {
	for pro in $(find ${S} -name "*.pro") ; do
		sed -i 's:$$QT_BUILD_TREE/bin/lrelease:${OE_QMAKE_LRELEASE}:g' $pro
	done

	sed -i s:SEDME:${S}: ${WORKDIR}/linux.conf
	sed -i \
	-e /QMAKE_MOC\ /d \
	-e /QMAKE_UIC\ /d \
	-e /QMAKE_UIC3\ /d \
	-e /QMAKE_RCC\ /d \
	${S}/configure
}

do_configure_append() {
	sed -e '/QMAKE_TARGET /d' -e '/TARGET /d' -i ${S}/translations/Makefile
}

QT_GLFLAGS ?= ""
QT_CONFIG_FLAGS += " -no-rpath -qt3support -silent ${QT_GLFLAGS}"

do_compile() {
	# Fixup missing wsegl header in some SGX SDKs
	if ! [ -e ${STAGING_INCDIR}/wsegl.h ] ; then
		cp src/3rdparty/powervr/wsegl.h src/plugins/gfxdrivers/powervr/QWSWSEGL/
	fi

	unset CFLAGS CXXFLAGS
	oe_runmake ${EXTRA_ENV}
}

do_install_append() {
	install -d ${D}${bindir}
	for i in rcc uic moc ; do
		install -m 0755 ${S}/bin/$i ${D}${bindir}/
	done

	#Append an E to the qtdemo file
	if [ -n "${QT_LIBINFIX}" ] ; then
		mv ${D}${bindir}/qtdemo ${D}${bindir}/qtdemo${QT_LIBINFIX}
	fi
}
