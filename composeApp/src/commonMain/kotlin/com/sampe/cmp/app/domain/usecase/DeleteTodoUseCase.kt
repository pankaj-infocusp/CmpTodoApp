package com.sampe.cmp.app.domain.usecase

import com.sampe.cmp.app.domain.repository.TaskRepository

class DeleteTodoUseCase(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(id: Long) {
        return taskRepository.deleteTodoById(id)
    }
}