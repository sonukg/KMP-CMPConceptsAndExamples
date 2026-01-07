package com.sonukg97.kmpmvvmarchitectureapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPMVVMArchitectureApp",
    ) {
        App()
    }
}