package org.sonukg

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform