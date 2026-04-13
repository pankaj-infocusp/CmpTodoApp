package com.sampe.cmp.app.navigation.events

import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.TodoDestination

object TodoEvent {

    data object OnTodoCreateClick: Event {
        override fun nextDestination(): Destination {
            return TodoDestination.AddTodoBottomSheet
        }
    }

    data class OnUpdateTodoClick(val id: Long): Event {
        override fun nextDestination(): Destination {
            return TodoDestination.UpdateTodo(id)
        }
    }
}