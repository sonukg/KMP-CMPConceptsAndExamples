package com.sonukg97.kmpcleanarchitechtureapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform