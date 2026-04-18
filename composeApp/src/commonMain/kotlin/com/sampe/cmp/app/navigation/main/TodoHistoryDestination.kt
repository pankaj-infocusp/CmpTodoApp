package com.sampe.cmp.app.navigation.main

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.history_tab_title
import sampecmpapp.composeapp.generated.resources.ic_history_icon

object TodoHistoryDestination {

    @Serializable
    data object History : Destination, BottomBarDestination {
        override val icon: DrawableResource
            get() = Res.drawable.ic_history_icon
        override val title: StringResource
            get() = Res.string.history_tab_title
    }
}