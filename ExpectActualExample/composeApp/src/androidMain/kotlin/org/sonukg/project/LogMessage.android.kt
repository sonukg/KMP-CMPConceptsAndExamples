package org.sonukg.project

import android.util.Log

actual fun logMessage(tag: String, messsage: String) {
    Log.d(tag,messsage)
}