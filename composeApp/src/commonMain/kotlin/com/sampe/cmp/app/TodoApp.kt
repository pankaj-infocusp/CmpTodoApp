package com.sampe.cmp.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.sampe.cmp.app.enums.ThemePreference
import com.sampe.cmp.app.ui.compose.common.TodoAppState
import com.sampe.cmp.app.ui.compose.common.rememberTodoAppState
import com.sampe.cmp.app.ui.compose.main.MainScreen
import com.sampe.cmp.app.ui.theme.AppTheme
import org.koin.compose.koinInject

@Composable
fun TodoApp(
    modifier: Modifier = Modifier,
    themePref: Int,
    appState: TodoAppState = rememberTodoAppState()
) {
    AppTheme(darkTheme = rememberIsDarkTheme(themePref)) {
        MainScreen(
            modifier = modifier,
            appState = appState
        )
    }
}

@Composable
private fun rememberIsDarkTheme(themePref: Int): Boolean {
    val isSystemDarkTheme = isSystemInDarkTheme()
    val theme = ThemePreference.getThemePreference(themePref)

    val isDarkTheme = when (theme) {
        ThemePreference.LIGHT -> false
        ThemePreference.DARK -> true
        ThemePreference.SYSTEM_DEFAULT -> isSystemDarkTheme
    }
    return isDarkTheme
}