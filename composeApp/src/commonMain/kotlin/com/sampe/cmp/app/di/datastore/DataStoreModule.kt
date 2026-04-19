package com.sampe.cmp.app.di.datastore

import com.sampe.cmp.app.data.datastore.DataStoreSource
import com.sampe.cmp.app.data.datastore.DataStoreSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/** DataStore Preference Module */
val dataStorePrefModule = module {
    singleOf(::DataStoreSourceImpl) bind DataStoreSource::class

    single {
        get<DataStoreSource>().getDataStorePreference()
    }
}