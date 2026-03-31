package com.sampe.cmp.app

class DesktopPlatform : Platform {
    override val name: String = "Desktop ${System.getProperty("os.arch")}"
}

actual fun getPlatform(): Platform = DesktopPlatform()