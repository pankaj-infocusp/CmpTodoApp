package com.sampe.cmp.app.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.ic_fav_icon
import sampecmpapp.composeapp.generated.resources.ic_home_icon
import sampecmpapp.composeapp.generated.resources.ic_settings_icon

sealed interface BottomNavKey: NavKey {
    val icon: DrawableResource
    val label: String

    @Serializable
    data object Home : BottomNavKey {
        override val icon: DrawableResource = Res.drawable.ic_home_icon
        override val label: String = "Home"
    }

    @Serializable
    data object Favorite : BottomNavKey {
        override val icon: DrawableResource = Res.drawable.ic_fav_icon
        override val label: String = "Favorite"
    }

    @Serializable
    data object Settings : BottomNavKey {
        override val icon: DrawableResource = Res.drawable.ic_settings_icon
        override val label: String = "Settings"
    }

}