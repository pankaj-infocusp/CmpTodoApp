package com.sampe.cmp.app.domain.repository

import com.sampe.cmp.app.database.entity.Todo
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun addTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
    suspend fun deleteTodoById(id: Long)
    suspend fun getTodoById(id: Long): Todo?
    fun getAllTodo(): Flow<List<Todo>>
    suspend fun deleteAllTodos()
    suspend fun updateTitle(id: Long, title: String)
    suspend fun updateBody(id: Long, body: String)
}