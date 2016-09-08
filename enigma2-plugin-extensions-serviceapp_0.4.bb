DESCRIPTION = "serviceapp service for enigma2"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "enigma2"

SRCREV = "761bb5f2048a2e983b7dc9fb1bc31de7e53471df"
SRC_URI = "git://github.com/mx3L/serviceapp.git;branch=master"

S = "${WORKDIR}/git"

inherit autotools pythonnative

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

do_install_append() {
	rm ${D}${libdir}/enigma2/python/Plugins/Extensions/ServiceApp/*.pyc
}

FILES_${PN} = "\
	${libdir}/enigma2/python/Plugins/Extensions/ServiceApp/*.pyo \
	${libdir}/enigma2/python/Plugins/Extensions/ServiceApp/serviceapp.so"

FILES_${PN}-dev = "\
	${libdir}/enigma2/python/Plugins/Extensions/ServiceApp/*.py \
	${libdir}/enigma2/python/Plugins/Extensions/ServiceApp/serviceapp.la"

