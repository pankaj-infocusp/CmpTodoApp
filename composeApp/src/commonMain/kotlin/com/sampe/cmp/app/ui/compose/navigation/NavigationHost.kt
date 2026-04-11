package com.sampe.cmp.app.ui.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation3.ui.NavDisplay
import com.sampe.cmp.app.di.navigation.NavGraphProvider
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.TopLevelDestination
import com.sampe.cmp.app.navigation.navcontroller.NavBackStack
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import org.koin.compose.koinInject

@Composable
fun NavigationHost(
    navBackStack: NavBackStack<Destination>,
    modifier: Modifier = Modifier
) {

    AppNavigation(
        navBackStack = navBackStack,
        modifier = modifier
    )
}

@Composable
private fun AppNavigation(
    modifier: Modifier = Modifier,
    navBackStack: NavBackStack<Destination>,
    navEventController: NavEventController = koinInject(),
    navGraphProvider: NavGraphProvider = koinInject()
) {

    LaunchedEffect(Unit) {
        navEventController.destinationState.collect { destination ->
            when (destination) {
                is Destination.Back -> {
                    navBackStack.removeLast()
                }

                is TopLevelDestination -> {
                    if (destination == navBackStack.currentDestination) {
                        navBackStack.clearTopLevel(destination)
                    } else {
                        navBackStack.addTopLevel(destination)
                    }
                }

                /*else -> {
                    navBackStack.add(destination)
                }*/
            }
        }
    }

    NavDisplay(
        modifier = modifier,
        backStack = navBackStack.backStack,
        onBack = { navBackStack.removeLast() },
        entryProvider = navGraphProvider.navigationGraph
    )
}