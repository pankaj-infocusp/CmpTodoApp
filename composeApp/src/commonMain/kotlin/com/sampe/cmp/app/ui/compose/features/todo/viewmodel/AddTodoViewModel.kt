package com.sampe.cmp.app.ui.compose.features.todo.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.domain.usecase.AddTodoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlin.time.Clock

class AddTodoViewModel(
    private val addTodoUseCase: AddTodoUseCase
): ViewModel() {

    fun addTodo(title: String, color: Color) {
        if (title.isEmpty()) return
        viewModelScope.launch(Dispatchers.IO) {
            val todo = Todo(
                title = title,
                body = "",
                color = color.toArgb(),
                createdAt = Clock.System.now().toEpochMilliseconds(),
                updatedAt = null
            )
            addTodoUseCase.invoke(todo)
        }
    }
}