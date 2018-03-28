SUMMARY = "DiGiCo UI Components"
DESCRIPTION = "DiGiCo internal UI Components."
HOMEPAGE = "https://github.com/DigicoUK/Components"
LICENSE = "CLOSED"
# LIC_FILES_CHKSUM = "file://LICENSE;md5=95cec7fbf076d62538f183af61e2c82e"

SRC_URI = "git://git@github.com/DigicoUK/Components.git;branch=master;protocol=ssh;user=ray"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "qtdeclarative"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}${libdir}/qt5/qml/DiGiCo/Components
    install -m 0755 ${B}/DiGiCo/Components/*.so ${D}${libdir}/qt5/qml/DiGiCo/Components
    cp -a ${B}/DiGiCo/Components/*.qml ${B}/DiGiCo/Components/qmldir ${D}${libdir}/qt5/qml/DiGiCo/Components/
}
