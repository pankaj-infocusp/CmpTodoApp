package com.sampe.cmp.app.ui.compose.features.settings.viewmodel

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampe.cmp.app.enums.ThemePreference
import com.sampe.cmp.app.utils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val dataStorePref: DataStore<Preferences>
): ViewModel() {

    val savedTheme = dataStorePref.data
        .map { preferences ->
            val key = intPreferencesKey(AppConstants.KEY_THEME_PREF)
            preferences[key] ?: ThemePreference.SYSTEM_DEFAULT.ordinal
        }.stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            ThemePreference.SYSTEM_DEFAULT.ordinal
        )

    fun saveThemePreference(themePreference: ThemePreference) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStorePref.edit {
                val key = intPreferencesKey(AppConstants.KEY_THEME_PREF)
                it[key] = themePreference.ordinal
            }
        }
    }
}