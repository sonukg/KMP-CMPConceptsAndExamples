package com.sonukg97.kmpsupabaseapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform