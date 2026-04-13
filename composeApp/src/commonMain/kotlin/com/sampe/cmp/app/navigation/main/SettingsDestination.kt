package com.sampe.cmp.app.navigation.main

import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.ic_settings_icon
import sampecmpapp.composeapp.generated.resources.settings_tab_title

object SettingsDestination {

    @Serializable
    data object Settings : Destination, TopLevelDestination {
        override val icon: DrawableResource
            get() = Res.drawable.ic_settings_icon
        override val title: StringResource
            get() = Res.string.settings_tab_title
    }
}