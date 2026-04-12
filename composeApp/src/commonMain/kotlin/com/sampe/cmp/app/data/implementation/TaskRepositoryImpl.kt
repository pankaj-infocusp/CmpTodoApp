package com.sampe.cmp.app.data.implementation

import com.sampe.cmp.app.database.daos.TodoDao
import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val todoDao: TodoDao
): TaskRepository {
    override suspend fun addTodo(todo: Todo) {
        todoDao.createTodo(todo)
    }

    override suspend fun updateTodo(todo: Todo) {
        todoDao.updateTodo(todo)
    }

    override suspend fun deleteTodoById(id: Long) {
        todoDao.deleteTodoById(id)
    }

    override suspend fun getTodoById(id: Long): Todo? {
        return todoDao.getTodoById(id)
    }

    override fun getAllTodo(): Flow<List<Todo>> {
        return todoDao.getAllTodoAsFlow()
    }

    override suspend fun deleteAllTodos() {
        todoDao.deleteAllTodos()
    }
}