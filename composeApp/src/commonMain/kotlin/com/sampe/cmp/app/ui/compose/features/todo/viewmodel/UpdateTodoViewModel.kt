package com.sampe.cmp.app.ui.compose.features.todo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.domain.usecase.GetTodoByIdUseCase
import com.sampe.cmp.app.domain.usecase.UpdateTodoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UpdateTodoViewModel(
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val getTodoByIdUseCase: GetTodoByIdUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    fun getTodoById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val todo = getTodoByIdUseCase(id)
            if (todo != null) {
                _uiState.value = UiState.Success(todo)
            } else {
                _uiState.value = UiState.Error
            }
        }
    }

    fun updateTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            updateTodoUseCase(todo)
        }
    }

   sealed class UiState {
       data object Loading: UiState()
       data class Success(val todo: Todo): UiState()
       data object Error: UiState()
   }
}