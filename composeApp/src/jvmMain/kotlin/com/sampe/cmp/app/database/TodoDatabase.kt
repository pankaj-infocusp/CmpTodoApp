package com.sampe.cmp.app.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.sampe.cmp.app.utils.AppConstants
import java.io.File

fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), AppConstants.DATABASE_NAME)
    return Room.databaseBuilder(
        name = dbFile.absolutePath
    )
}