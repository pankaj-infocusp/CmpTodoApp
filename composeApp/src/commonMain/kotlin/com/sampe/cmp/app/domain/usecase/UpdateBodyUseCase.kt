package com.sampe.cmp.app.domain.usecase

import com.sampe.cmp.app.domain.repository.TaskRepository

class UpdateBodyUseCase(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(id: Long, body: String) {
        taskRepository.updateBody(id, body)
    }
}