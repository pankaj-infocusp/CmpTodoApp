package com.sampe.cmp.app.ui.compose.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sampe.cmp.app.navigation.events.HomeEvent
import com.sampe.cmp.app.navigation.main.BottomBarDestination
import com.sampe.cmp.app.navigation.main.BottomBarDestinations
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
fun MainScreen(
    modifier: Modifier = Modifier,
    appState: TodoAppState
) {
    MainScreenContent(
        modifier = modifier,
        appState = appState
    )
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    appState: TodoAppState,
    navEventController: NavEventController = koinInject()
) {

    val navItems by rememberSaveable { mutableStateOf(BottomBarDestinations) }
    val setCurrentDestination = { destination: BottomBarDestination ->
        navEventController.sendEvent(HomeEvent.OnTabClick(destination))
    }

    MainScreenScaffold(
        appState = appState,
        navItems = navItems.toImmutableList(),
        currentDestination = appState.navBackState.currentDestination as BottomBarDestination,
        setCurrentDestination = setCurrentDestination,
        modifier = modifier
    )
}

@Composable
private fun MainScreenScaffold(
    appState: TodoAppState,
    navItems: ImmutableList<BottomBarDestination>,
    currentDestination: BottomBarDestination,
    setCurrentDestination: (BottomBarDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    val isTopAppBarVisible = appState.navBackState.isTopBarVisible
    val topBarOffset: Dp by animateDpAsState(
        targetValue = if (isTopAppBarVisible) 0.dp else 64.dp,
        animationSpec = tween(easing = LinearEasing),
    )
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
                AnimatedVisibility(
                    visible = isTopAppBarVisible,
                ) {
                    CommonCenterTopAppBar(
                        title = stringResource(currentDestination.title)
                    )
                }
            },
            contentWindowInsets = WindowInsets(left = 0, top = 0, right = 0, bottom = 0),
        ) { padding ->
            val topPadding = padding.calculateTopPadding() - topBarOffset
            NavigationHost(
                navBackStack = appState.navBackState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = padding.calculateStartPadding(LocalLayoutDirection.current),
                        end = padding.calculateEndPadding(LocalLayoutDirection.current),
                        top = if (topPadding > 0.dp) topPadding else 0.dp,
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
    navItems: List<BottomBarDestination>,
    currentDestination: BottomBarDestination,
    setCurrentDestination: (BottomBarDestination) -> Unit
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
