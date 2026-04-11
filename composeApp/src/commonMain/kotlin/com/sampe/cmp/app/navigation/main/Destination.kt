package com.sampe.cmp.app.navigation.main

import kotlinx.serialization.Serializable

sealed interface Destination {

    @Serializable
    data object Back : Destination
}

/**
 * All top-level (BottomBar) destinations.
 */
val TopLevelDestinations: Set<TopLevelDestination> = setOf(
    HomeDestination.Home,
    HomeDestination.Favorites,
    HomeDestination.Settings,
)