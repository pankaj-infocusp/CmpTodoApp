package com.sampe.cmp.app.navigation.main

import kotlinx.serialization.Serializable

object TodoDestination {

    @Serializable
    data class UpdateTodo(val todoId: Long): Destination
    @Serializable
    data object AddTodoBottomSheet: Destination, TopAppBarVisible
}