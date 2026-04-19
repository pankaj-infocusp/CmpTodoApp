package com.sampe.cmp.app.enums

import org.jetbrains.compose.resources.StringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.dark_theme
import sampecmpapp.composeapp.generated.resources.light_theme
import sampecmpapp.composeapp.generated.resources.system_default_theme

enum class ThemePreference(val value: Int, val titleRes: StringResource) {
    SYSTEM_DEFAULT(value = 0, Res.string.system_default_theme),
    LIGHT(value = 1, Res.string.light_theme),
    DARK(value = 2, Res.string.dark_theme);

    companion object {
        fun getThemePreference(value: Int): ThemePreference {
            return when(value) {
                1 -> LIGHT
                2 -> DARK
                else -> SYSTEM_DEFAULT
            }
        }

        fun getThemePreferenceValue(themePreference: ThemePreference): Int {
            return when(themePreference) {
                LIGHT -> 1
                DARK -> 2
                SYSTEM_DEFAULT -> 0
            }
        }
    }
}