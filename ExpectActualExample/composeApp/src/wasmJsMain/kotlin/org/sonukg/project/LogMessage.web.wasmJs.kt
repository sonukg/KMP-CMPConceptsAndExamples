package org.sonukg.project

actual fun webLog(tag: String, messsage: String) {
    print("[$tag]: $messsage")
}