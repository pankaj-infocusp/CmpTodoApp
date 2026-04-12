package com.sampe.cmp.app.di.room

import com.sampe.cmp.app.data.local.RoomDataSource
import com.sampe.cmp.app.data.local.RoomDataSourceImpl
import com.sampe.cmp.app.database.AppDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/** Room Database Module */
val roomModule = module {
    singleOf(::RoomDataSourceImpl) bind RoomDataSource::class

    //Provides a AppDatabase
    single {
        get<RoomDataSource>().getRoomDatabase()
    }

    // Provides Dao
    single {
        get<AppDatabase>().todoDao()
    }
}