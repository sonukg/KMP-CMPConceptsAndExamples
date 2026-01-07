package org.sonukg.project

actual fun webLog(tag: String, messsage: String) {
    console.log("[$tag]: $messsage")
}