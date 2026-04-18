package com.sampe.cmp.app.navigation.main

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.completed_todo_title
import sampecmpapp.composeapp.generated.resources.ic_fav_icon

object CompletedTodoDestination {

    @Serializable
    data object CompletedTodos : Destination, BottomBarDestination {
        override val icon: DrawableResource
            get() = Res.drawable.ic_fav_icon
        override val title: StringResource
            get() = Res.string.completed_todo_title
    }
}