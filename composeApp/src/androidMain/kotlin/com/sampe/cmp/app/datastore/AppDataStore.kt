package com.sampe.cmp.app.datastore

import android.content.Context
import androidx.datastore.core.FileStorage
import androidx.datastore.core.Storage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesFileSerializer
import com.sampe.cmp.app.utils.AppConstants

fun getDataStore(context: Context): Storage<Preferences> {
    return FileStorage(
        serializer = PreferencesFileSerializer,
        produceFile = {
            context.filesDir.resolve(AppConstants.DATASTORE_PREF_NAME)
        }
    )
}