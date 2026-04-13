package com.sampe.cmp.app.domain.usecase

import com.sampe.cmp.app.domain.repository.TaskRepository

class UpdateTitleUseCase(
    private val taskRepository: TaskRepository
) {
    suspend operator fun invoke(id: Long, title: String) {
        taskRepository.updateTitle(id, title)
    }
}