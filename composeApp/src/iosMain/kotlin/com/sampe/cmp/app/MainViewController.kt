package com.sampe.cmp.app

import androidx.compose.runtime.getValue
import androidx.compose.ui.window.ComposeUIViewController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sampe.cmp.app.ui.compose.features.settings.viewmodel.SettingsViewModel
import org.koin.compose.viewmodel.koinViewModel

fun MainViewController() = ComposeUIViewController {
    val viewModel: SettingsViewModel = koinViewModel()
    val themePref by viewModel.savedTheme.collectAsStateWithLifecycle()
    TodoApp(themePref = themePref)
}