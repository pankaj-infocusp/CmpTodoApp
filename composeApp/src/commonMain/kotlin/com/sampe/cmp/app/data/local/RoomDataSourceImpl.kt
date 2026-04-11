package com.sampe.cmp.app.data.local

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.sampe.cmp.app.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class RoomDataSourceImpl(
    private val builder: RoomDatabase.Builder<AppDatabase>
): RoomDataSource {
    override fun getRoomDatabase(): AppDatabase {
        return builder
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .fallbackToDestructiveMigration(true)
            .build()
    }
}