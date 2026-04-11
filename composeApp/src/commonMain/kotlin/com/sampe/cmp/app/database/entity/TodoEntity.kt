package com.sampe.cmp.app.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TodoEntity")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val body: String,
    val color: Int,
    val createdAt: Long,
    val updatedAt: Long?
)
