package com.sampe.cmp.app.navigation.main

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.history_tab_title
import sampecmpapp.composeapp.generated.resources.todo_tab_title
import sampecmpapp.composeapp.generated.resources.ic_history_icon
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
    data object HistoryTab : Destination, BottomBarDestination, TopAppBarVisible {
        override val icon: DrawableResource
            get() = Res.drawable.ic_history_icon
        override val title: StringResource
            get() = Res.string.history_tab_title
    }

    @Serializable
    data object SettingsTab : Destination, BottomBarDestination, TopAppBarVisible {
        override val icon: DrawableResource
            get() = Res.drawable.ic_settings_icon
        override val title: StringResource
            get() = Res.string.settings_tab_title
    }
}