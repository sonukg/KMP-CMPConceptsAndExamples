package org.sonukg.project

import platform.Foundation.NSLog

actual fun logMessage(tag: String, messsage: String) {
    NSLog("$tag: $messsage")
}