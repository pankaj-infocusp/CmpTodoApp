package com.sampe.cmp.app.ui.compose.features.history.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampe.cmp.app.domain.usecase.DeleteTodoUseCase
import com.sampe.cmp.app.domain.usecase.TodoHistoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoHistoryViewModel(
    private val deleteTodoUseCase: DeleteTodoUseCase,
    todoHistoryUseCase: TodoHistoryUseCase
): ViewModel() {

    val completedTodos = todoHistoryUseCase.invoke()
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun deleteTodo(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteTodoUseCase.invoke(id)
        }
    }
}