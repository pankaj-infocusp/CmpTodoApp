package com.sampe.cmp.app.navigation.events

import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.BottomBarDestination
import kotlinx.serialization.Serializable

object HomeEvent {
    @Serializable
    data class OnTabClick(val topLevel: BottomBarDestination) : Event {
        override fun nextDestination(): Destination = topLevel as Destination
    }
}