package com.sampe.cmp.app.datastore

import androidx.datastore.core.FileStorage
import androidx.datastore.core.Storage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesFileSerializer
import com.sampe.cmp.app.utils.AppConstants
import java.io.File

fun getDataStore(): Storage<Preferences> {
    return FileStorage(
        serializer = PreferencesFileSerializer,
        produceFile = {
            File(System.getProperty("java.io.tmpdir"), AppConstants.DATASTORE_PREF_NAME)
        }
    )
}