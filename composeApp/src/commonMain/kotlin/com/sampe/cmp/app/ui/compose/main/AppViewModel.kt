package com.sampe.cmp.app.ui.compose.main

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampe.cmp.app.enums.ThemePreference
import com.sampe.cmp.app.utils.AppConstants
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class AppViewModel(
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
}