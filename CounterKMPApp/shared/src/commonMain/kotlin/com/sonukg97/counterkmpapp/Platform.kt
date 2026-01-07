package com.sonukg97.counterkmpapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform