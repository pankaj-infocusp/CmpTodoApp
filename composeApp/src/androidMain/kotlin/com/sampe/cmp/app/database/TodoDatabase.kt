package com.sampe.cmp.app.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sampe.cmp.app.utils.AppConstants

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(AppConstants.DATABASE_NAME)
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}