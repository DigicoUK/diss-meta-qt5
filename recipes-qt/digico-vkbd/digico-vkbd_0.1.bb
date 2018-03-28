SUMMARY = "Qt5 virtual keyboard"
DESCRIPTION = "On screen virtual keyboard."
HOMEPAGE = "https://github.com/DigicoUK/virtual-keyboard-qpa-plugin"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=95cec7fbf076d62538f183af61e2c82e"

SRC_URI = "git://git@github.com/DigicoUK/virtual-keyboard-qpa-plugin.git;branch=Qt5.5.1;protocol=ssh;user=ray"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "qtdeclarative"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}${libdir}/qt5/qml/DiGiCo/VirtualKeyboard
    install -d ${D}${libdir}/qt5/plugins/platforminputcontexts
    install -m 0755 ${B}/src/libvkbqpa.so ${D}${libdir}/qt5/plugins/platforminputcontexts
    cp -a ${S}/qml/*.qml ${S}/qml/qmldir ${D}${libdir}/qt5/qml/DiGiCo/VirtualKeyboard/
}
