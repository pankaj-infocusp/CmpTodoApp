package com.sampe.cmp.app.domain.usecase

import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TodoHistoryUseCase(
    private val taskRepository: TaskRepository
) {
    operator fun invoke(): Flow<List<Todo>> {
        return taskRepository.getCompletedTodos()
    }
}