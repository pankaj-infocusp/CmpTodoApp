package com.sampe.cmp.app.ui.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import com.sampe.cmp.app.navigation.events.HomeEvent
import com.sampe.cmp.app.navigation.main.TopLevelDestination
import com.sampe.cmp.app.navigation.main.TopLevelDestinations
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.ui.compose.common.CommonCenterTopAppBar
import com.sampe.cmp.app.ui.compose.common.TodoAppState
import com.sampe.cmp.app.ui.compose.navigation.NavigationHost
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    appState: TodoAppState
) {
    HomeScreenContent(
        modifier = modifier,
        appState = appState
    )
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier,
    appState: TodoAppState,
    navEventController: NavEventController = koinInject()
) {

    val navItems by rememberSaveable { mutableStateOf(TopLevelDestinations) }
    val setCurrentDestination = { destination: TopLevelDestination ->
        navEventController.sendEvent(HomeEvent.OnTabClick(destination))
    }

    HomeScreenScaffold(
        appState = appState,
        navItems = navItems.toImmutableList(),
        currentDestination = appState.navBackState.currentDestination as TopLevelDestination,
        setCurrentDestination = setCurrentDestination,
        modifier = modifier
    )
}

@Composable
private fun HomeScreenScaffold(
    appState: TodoAppState,
    navItems: ImmutableList<TopLevelDestination>,
    currentDestination: TopLevelDestination,
    setCurrentDestination: (TopLevelDestination) -> Unit,
    modifier: Modifier = Modifier
) {

    NavigationSuiteScaffold(
        modifier = modifier,
        navigationSuiteItems = {
            bottomNavigationBar(
                navItems = navItems,
                currentDestination = currentDestination,
                setCurrentDestination = setCurrentDestination
            )
        }
    ) {
        Scaffold(
            topBar = {
                CommonCenterTopAppBar(
                    title = stringResource(currentDestination.title)
                )
            },
            contentWindowInsets = WindowInsets(left = 0, top = 0, right = 0, bottom = 0),
        ) { padding ->
            NavigationHost(
                navBackStack = appState.navBackState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = padding.calculateStartPadding(LocalLayoutDirection.current),
                        end = padding.calculateEndPadding(LocalLayoutDirection.current),
                        top = padding.calculateTopPadding(),
                        bottom = padding.calculateBottomPadding()
                    ).consumeWindowInsets(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)
                    )
            )
        }
    }
}


private fun NavigationSuiteScope.bottomNavigationBar(
    navItems: List<TopLevelDestination>,
    currentDestination: TopLevelDestination,
    setCurrentDestination: (TopLevelDestination) -> Unit
) {
    navItems.forEach { destination ->
        val isSelected = currentDestination == destination
        val title = destination.title
        val icon = destination.icon

        item(
            selected = isSelected,
            onClick = { setCurrentDestination(destination) },
            icon = {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = stringResource(title),
                )
            },
            label = {
                Text(
                    text = stringResource(title),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        )
    }
}
