package com.sonukg97.kmpmviarchitectureapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPMVIArchitectureApp",
    ) {
        App()
    }
}