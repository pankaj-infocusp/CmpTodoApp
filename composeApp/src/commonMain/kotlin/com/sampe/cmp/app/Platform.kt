package com.sampe.cmp.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform