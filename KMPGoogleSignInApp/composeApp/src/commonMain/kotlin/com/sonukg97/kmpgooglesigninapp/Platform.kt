package com.sonukg97.kmpgooglesigninapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform