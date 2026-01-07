package com.sonukg97.kmpmvvmarchitectureapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform