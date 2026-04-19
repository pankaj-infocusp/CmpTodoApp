package com.sampe.cmp.app.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.Storage
import androidx.datastore.preferences.core.Preferences

class DataStoreSourceImpl(
    private val storage: Storage<Preferences>
): DataStoreSource {

    override fun getDataStorePreference(): DataStore<Preferences> {
        return DataStoreFactory.create(storage)
    }
}