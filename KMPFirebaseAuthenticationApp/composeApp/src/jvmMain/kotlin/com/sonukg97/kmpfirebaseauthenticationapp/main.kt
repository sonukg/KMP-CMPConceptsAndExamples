package com.sonukg97.kmpfirebaseauthenticationapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPFirebaseAuthenticationApp",
    ) {
        App()
    }
}