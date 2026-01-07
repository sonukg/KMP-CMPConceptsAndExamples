package org.sonukg.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform