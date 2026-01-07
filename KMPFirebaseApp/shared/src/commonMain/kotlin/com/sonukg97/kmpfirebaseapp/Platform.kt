package com.sonukg97.kmpfirebaseapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform