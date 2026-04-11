package com.sampe.cmp.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sampe.cmp.app.di.initKoin

fun main() = application {
    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "SampeCmpApp",
    ) {
        TodoApp()
    }
}