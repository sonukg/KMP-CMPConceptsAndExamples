package com.sonukg97.kmpfirebaseauthenticationapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform