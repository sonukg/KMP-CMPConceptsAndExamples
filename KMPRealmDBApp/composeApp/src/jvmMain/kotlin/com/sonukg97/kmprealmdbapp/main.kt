package com.sonukg97.kmprealmdbapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPRealmDBApp",
    ) {
        App()
    }
}