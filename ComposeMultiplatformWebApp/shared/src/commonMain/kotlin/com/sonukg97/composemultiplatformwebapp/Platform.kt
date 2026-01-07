package com.sonukg97.composemultiplatformwebapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform