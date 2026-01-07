package com.sonukg97.composemultiplatformwebapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "ComposeMultiplatformWebApp",
    ) {
        App()
    }
}