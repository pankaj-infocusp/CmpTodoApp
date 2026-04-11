package com.sampe.cmp.app.navigation.events

import com.sampe.cmp.app.navigation.main.Destination

sealed interface Event {

    fun nextDestination(): Destination

    data object OnBack : Event {
        override fun nextDestination(): Destination = Destination.Back
    }
}
