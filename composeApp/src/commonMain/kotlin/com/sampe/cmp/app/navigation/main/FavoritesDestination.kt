package com.sampe.cmp.app.navigation.main

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.favorites_title
import sampecmpapp.composeapp.generated.resources.ic_fav_icon

object FavoritesDestination {

    @Serializable
    data object Favorites : Destination, TopLevelDestination {
        override val icon: DrawableResource
            get() = Res.drawable.ic_fav_icon
        override val title: StringResource
            get() = Res.string.favorites_title
    }
}