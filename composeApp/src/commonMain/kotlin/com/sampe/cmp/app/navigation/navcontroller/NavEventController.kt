package com.sampe.cmp.app.navigation.navcontroller

import com.sampe.cmp.app.navigation.events.Event
import com.sampe.cmp.app.navigation.main.Destination
import kotlinx.coroutines.flow.SharedFlow

/**
 * Controller responsible to handle the navigation events.
 */
interface NavEventController {

    /**
     * Flow to observe the destination changes.
     */
    val destinationState: SharedFlow<Destination>

    /**
     * Sends the event to the controller.
     *
     * @param event the event to be sent
     */
    fun sendEvent(event: Event)
}
