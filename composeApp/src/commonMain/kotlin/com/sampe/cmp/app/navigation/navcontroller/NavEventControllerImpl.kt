package com.sampe.cmp.app.navigation.navcontroller

import com.sampe.cmp.app.coroutine.AppCoroutineScope
import com.sampe.cmp.app.navigation.events.Event
import com.sampe.cmp.app.navigation.main.Destination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn

class NavEventControllerImpl(
    private val appCoroutineScope: AppCoroutineScope,
): NavEventController {

    private val navigationEventState: MutableSharedFlow<Event> = MutableSharedFlow()

    override val destinationState: SharedFlow<Destination>
        get() = navigationEventState
            .map { event ->
                event.nextDestination()
            }
            .shareIn(
                scope = CoroutineScope(appCoroutineScope.context),
                started = SharingStarted.WhileSubscribed(),
            )

    override fun sendEvent(event: Event) {
        appCoroutineScope.launch {
            navigationEventState.emit(event)
        }
    }
}