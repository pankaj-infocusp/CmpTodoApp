package com.sampe.cmp.app.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sampe.cmp.app.database.entity.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createTodo(item: Todo)

    @Update
    suspend fun updateTodo(item: Todo)

    @Query("SELECT * FROM TodoEntity")
    suspend fun getAllTodo(): List<Todo>

    @Query("SELECT * FROM TodoEntity")
    fun getAllTodoAsFlow(): Flow<List<Todo>>

    @Query("SELECT * FROM TodoEntity WHERE id = :id")
    suspend fun getTodoById(id: Long): Todo?

    @Query("DELETE FROM TodoEntity")
    suspend fun deleteAllTodos()

    @Query("DELETE FROM TodoEntity WHERE id = :id")
    suspend fun deleteTodoById(id: Long)

    @Query("SELECT count(*) FROM TodoEntity")
    suspend fun count(): Int
}