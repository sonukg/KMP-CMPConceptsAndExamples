package org.sonukg.project

actual fun logMessage(tag: String, messsage: String) {
    println("$tag: $messsage")
}