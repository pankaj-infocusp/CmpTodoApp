package com.sampe.cmp.app.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

interface DataStoreSource {
    fun getDataStorePreference(): DataStore<Preferences>
}