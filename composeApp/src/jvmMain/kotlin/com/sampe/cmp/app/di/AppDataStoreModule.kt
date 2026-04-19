package com.sampe.cmp.app.di

import androidx.datastore.core.Storage
import androidx.datastore.preferences.core.Preferences
import com.sampe.cmp.app.datastore.getDataStore
import org.koin.dsl.module

actual fun dataStoreModule() = module {
    single<Storage<Preferences>> {
        getDataStore()
    }
}