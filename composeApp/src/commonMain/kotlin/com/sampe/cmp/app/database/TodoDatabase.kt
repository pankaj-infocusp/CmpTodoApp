package com.sampe.cmp.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sampe.cmp.app.database.daos.TodoDao
import com.sampe.cmp.app.database.entity.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}