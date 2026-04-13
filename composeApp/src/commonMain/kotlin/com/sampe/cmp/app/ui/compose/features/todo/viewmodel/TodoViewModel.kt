package com.sampe.cmp.app.ui.compose.features.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.domain.usecase.DeleteTodoUseCase
import com.sampe.cmp.app.domain.usecase.GetAllTodosUseCase
import com.sampe.cmp.app.domain.usecase.UpdateTodoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoViewModel(
    getAllTodosUseCase: GetAllTodosUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
): ViewModel() {

    val todos = getAllTodosUseCase.invoke()
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun onTodoCompleted(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            updateTodoUseCase.invoke(todo)
        }
    }

    fun deleteTodo(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteTodoUseCase.invoke(id)
        }
    }
}