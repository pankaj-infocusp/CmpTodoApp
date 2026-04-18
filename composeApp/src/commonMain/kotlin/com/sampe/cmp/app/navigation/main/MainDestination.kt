package com.sampe.cmp.app.navigation.main

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.completed_todo_title
import sampecmpapp.composeapp.generated.resources.todo_tab_title
import sampecmpapp.composeapp.generated.resources.ic_fav_icon
import sampecmpapp.composeapp.generated.resources.ic_home_icon
import sampecmpapp.composeapp.generated.resources.ic_settings_icon
import sampecmpapp.composeapp.generated.resources.settings_tab_title

object MainDestination {

    @Serializable
    data object TodoTab : Destination, BottomBarDestination, TopAppBarVisible {
        override val icon: DrawableResource
            get() = Res.drawable.ic_home_icon
        override val title: StringResource
            get() = Res.string.todo_tab_title
    }

    @Serializable
    data object CompletedTodoTab : Destination, BottomBarDestination, TopAppBarVisible {
        override val icon: DrawableResource
            get() = Res.drawable.ic_fav_icon
        override val title: StringResource
            get() = Res.string.completed_todo_title
    }

    @Serializable
    data object SettingsTab : Destination, BottomBarDestination, TopAppBarVisible {
        override val icon: DrawableResource
            get() = Res.drawable.ic_settings_icon
        override val title: StringResource
            get() = Res.string.settings_tab_title
    }
}