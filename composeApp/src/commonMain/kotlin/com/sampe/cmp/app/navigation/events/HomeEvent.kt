package com.sampe.cmp.app.navigation.events

import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.TopLevelDestination
import kotlinx.serialization.Serializable

object HomeEvent {
    @Serializable
    data class OnTabClick(val topLevel: TopLevelDestination) : Event {
        override fun nextDestination(): Destination = topLevel as Destination
    }
}