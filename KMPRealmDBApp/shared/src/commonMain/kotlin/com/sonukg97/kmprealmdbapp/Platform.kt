package com.sonukg97.kmprealmdbapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform