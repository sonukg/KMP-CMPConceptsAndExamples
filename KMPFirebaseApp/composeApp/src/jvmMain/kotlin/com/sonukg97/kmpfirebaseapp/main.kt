package com.sonukg97.kmpfirebaseapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPFirebaseApp",
    ) {
        App()
    }
}