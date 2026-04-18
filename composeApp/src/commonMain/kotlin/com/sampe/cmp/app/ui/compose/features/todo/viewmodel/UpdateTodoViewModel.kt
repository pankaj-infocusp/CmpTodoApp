package com.sampe.cmp.app.ui.compose.features.todo.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampe.cmp.app.coroutine.CoroutineDebouncer
import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.domain.usecase.DeleteTodoUseCase
import com.sampe.cmp.app.domain.usecase.GetTodoByIdUseCase
import com.sampe.cmp.app.domain.usecase.UpdateBodyUseCase
import com.sampe.cmp.app.domain.usecase.UpdateTitleUseCase
import com.sampe.cmp.app.domain.usecase.UpdateTodoUseCase
import com.sampe.cmp.app.utils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UpdateTodoViewModel(
    private val updateTitleUseCase: UpdateTitleUseCase,
    private val updateBodyUseCase: UpdateBodyUseCase,
    private val getTodoByIdUseCase: GetTodoByIdUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val debouncer: CoroutineDebouncer
): ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun getTodoById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            val todo = getTodoByIdUseCase(id)
            println("Todo: $todo")
            if (todo != null) {
                _uiState.emit(UiState.Success(todo))
            } else {
                _uiState.value = UiState.Error
            }
        }
    }

    fun updateTitle(id: Long, title: String) {
        debouncer(coroutineScope = viewModelScope) {
            updateTitleUseCase(id, title)
        }
    }

    fun updateBody(id: Long, body: String) {
        debouncer(coroutineScope = viewModelScope) {
            updateBodyUseCase(id, body)
        }
    }

    fun deleteTodo(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteTodoUseCase.invoke(id)
            _uiState.emit(UiState.Back)
        }
    }

   sealed class UiState {
       data object Loading: UiState()
       data class Success(val todo: Todo): UiState()
       data object Error: UiState()
       data object Back: UiState()
   }
}