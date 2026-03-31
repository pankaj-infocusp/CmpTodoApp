package com.sampe.cmp.app.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface SettingsNavKey: NavKey {

    @Serializable
    data object SettingsScreen : SettingsNavKey

}