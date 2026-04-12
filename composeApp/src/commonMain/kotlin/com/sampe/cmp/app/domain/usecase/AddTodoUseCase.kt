package com.sampe.cmp.app.domain.usecase

import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.domain.repository.TaskRepository

class AddTodoUseCase(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(todo: Todo) {
        taskRepository.addTodo(todo)
    }
}