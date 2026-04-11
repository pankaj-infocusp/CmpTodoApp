package com.sampe.cmp.app.di

import androidx.room.RoomDatabase
import com.sampe.cmp.app.database.AppDatabase
import com.sampe.cmp.app.database.getDatabaseBuilder
import org.koin.dsl.module

actual fun roomBuilderModule() = module {
    single<RoomDatabase.Builder<AppDatabase>> {
        getDatabaseBuilder(get())
    }
}