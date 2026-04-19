package com.sampe.cmp.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sampe.cmp.app.enums.ThemePreference
import com.sampe.cmp.app.ui.compose.common.TodoAppState
import com.sampe.cmp.app.ui.compose.common.rememberTodoAppState
import com.sampe.cmp.app.ui.compose.main.AppViewModel
import com.sampe.cmp.app.ui.compose.main.MainScreen
import com.sampe.cmp.app.ui.theme.AppTheme
import org.koin.compose.koinInject

@Composable
fun TodoApp(
    modifier: Modifier = Modifier,
    appState: TodoAppState = rememberTodoAppState()
) {
    AppTheme(darkTheme = rememberIsDarkTheme()) {
        MainScreen(
            modifier = modifier,
            appState = appState
        )
    }
}

@Composable
private fun rememberIsDarkTheme(vm: AppViewModel = koinInject()): Boolean {
    val isSystemDarkTheme = isSystemInDarkTheme()
    val themePref by vm.savedTheme.collectAsStateWithLifecycle()
    val theme = ThemePreference.getThemePreference(themePref)

    val isDarkTheme = when (theme) {
        ThemePreference.LIGHT -> false
        ThemePreference.DARK -> true
        ThemePreference.SYSTEM_DEFAULT -> isSystemDarkTheme
    }
    return isDarkTheme
}