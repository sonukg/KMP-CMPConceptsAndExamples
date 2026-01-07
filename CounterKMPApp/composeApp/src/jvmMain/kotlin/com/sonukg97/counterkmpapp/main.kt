package com.sonukg97.counterkmpapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "CounterKMPApp",
    ) {
        App()
    }
}