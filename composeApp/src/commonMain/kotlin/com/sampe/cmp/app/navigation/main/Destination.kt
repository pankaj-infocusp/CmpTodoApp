package com.sampe.cmp.app.navigation.main

import kotlinx.serialization.Serializable

sealed interface Destination {

    @Serializable
    data object Back : Destination
}

/** All BottomBar destinations. */
val BottomBarDestinations: Set<BottomBarDestination> = setOf(
    MainDestination.TodoTab,
    MainDestination.CompletedTodoTab,
    MainDestination.SettingsTab,
)

/** All Destinations that should have TopBar visible */
val TopbarVisibleDestinations: Set<TopAppBarVisible> = setOf(
    MainDestination.TodoTab,
    MainDestination.CompletedTodoTab,
    MainDestination.SettingsTab
)