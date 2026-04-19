package com.sampe.cmp.app

import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sampe.cmp.app.di.initKoin
import com.sampe.cmp.app.ui.compose.features.settings.viewmodel.SettingsViewModel
import org.koin.compose.viewmodel.koinViewModel

fun main() = application {
    initKoin()
    val viewModel: SettingsViewModel = koinViewModel()
    val themePref by viewModel.savedTheme.collectAsStateWithLifecycle()

    Window(
        onCloseRequest = ::exitApplication,
        title = "SampeCmpApp",
    ) {
        TodoApp(themePref = themePref)
    }
}