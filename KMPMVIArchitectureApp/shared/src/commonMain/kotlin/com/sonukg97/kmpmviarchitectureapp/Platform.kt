package com.sonukg97.kmpmviarchitectureapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform