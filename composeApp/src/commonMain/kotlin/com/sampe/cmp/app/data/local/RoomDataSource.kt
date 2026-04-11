package com.sampe.cmp.app.data.local

import com.sampe.cmp.app.database.AppDatabase

interface RoomDataSource {
    fun getRoomDatabase(): AppDatabase
}