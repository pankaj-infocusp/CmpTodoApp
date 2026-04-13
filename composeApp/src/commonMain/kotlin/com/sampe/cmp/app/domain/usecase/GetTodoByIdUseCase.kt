package com.sampe.cmp.app.domain.usecase

import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.domain.repository.TaskRepository

class GetTodoByIdUseCase(
    private val taskRepository: TaskRepository
) {

    suspend operator fun invoke(id: Long): Todo? {
        return taskRepository.getTodoById(id)
    }
}