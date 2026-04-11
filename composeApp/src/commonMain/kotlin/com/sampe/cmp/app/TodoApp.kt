package com.sampe.cmp.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sampe.cmp.app.ui.compose.common.TodoAppState
import com.sampe.cmp.app.ui.compose.common.rememberTodoAppState
import com.sampe.cmp.app.ui.home.HomeScreen
import com.sampe.cmp.app.ui.theme.AppTheme

@Composable
fun TodoApp(
    modifier: Modifier = Modifier,
    appState: TodoAppState = rememberTodoAppState()
) {
    AppTheme {
        HomeScreen(
            modifier = modifier,
            appState = appState
        )
    }
}