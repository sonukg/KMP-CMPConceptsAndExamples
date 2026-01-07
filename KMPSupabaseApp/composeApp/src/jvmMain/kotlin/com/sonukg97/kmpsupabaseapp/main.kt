package com.sonukg97.kmpsupabaseapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPSupabaseApp",
    ) {
        App()
    }
}