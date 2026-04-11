package com.sampe.cmp.app.navigation.main

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.favorites_title
import sampecmpapp.composeapp.generated.resources.home_title
import sampecmpapp.composeapp.generated.resources.ic_fav_icon
import sampecmpapp.composeapp.generated.resources.ic_home_icon
import sampecmpapp.composeapp.generated.resources.ic_settings_icon
import sampecmpapp.composeapp.generated.resources.settings_title

object HomeDestination {

    @Serializable
    data object Home : Destination, TopLevelDestination {
        override val icon: DrawableResource
            get() = Res.drawable.ic_home_icon
        override val title: StringResource
            get() = Res.string.home_title
    }

    @Serializable
    data object Favorites : Destination, TopLevelDestination {
        override val icon: DrawableResource
            get() = Res.drawable.ic_fav_icon
        override val title: StringResource
            get() = Res.string.favorites_title
    }

    @Serializable
    data object Settings : Destination, TopLevelDestination {
        override val icon: DrawableResource
            get() = Res.drawable.ic_settings_icon
        override val title: StringResource
            get() = Res.string.settings_title
    }
}