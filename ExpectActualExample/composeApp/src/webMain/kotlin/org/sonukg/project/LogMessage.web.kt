package org.sonukg.project

actual fun logMessage(tag: String, messsage: String) {
    webLog(tag,messsage)
}

expect fun webLog(tag: String,messsage: String)