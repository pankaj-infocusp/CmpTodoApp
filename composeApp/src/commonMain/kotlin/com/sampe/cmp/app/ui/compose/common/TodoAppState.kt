package com.sampe.cmp.app.ui.compose.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.MainDestination
import com.sampe.cmp.app.navigation.navcontroller.NavBackStack

@Stable
data class TodoAppState(val navBackState: NavBackStack<Destination>)

/** Function to remember navigation state */
@Composable
fun rememberTodoAppState(
    navBackStack: NavBackStack<Destination> = remember {
        NavBackStack(MainDestination.TodoTab)
    }
): TodoAppState = remember(navBackStack) {
    TodoAppState(navBackStack)
}