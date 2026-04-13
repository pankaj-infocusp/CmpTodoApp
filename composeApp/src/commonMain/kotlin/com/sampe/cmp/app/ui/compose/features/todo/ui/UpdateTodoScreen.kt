package com.sampe.cmp.app.ui.compose.features.todo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.ui.compose.features.todo.viewmodel.UpdateTodoViewModel
import org.jetbrains.compose.resources.stringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.something_went_wrong

@Composable
fun UpdateTodoScreen(
    modifier: Modifier = Modifier,
    uiState: UpdateTodoViewModel.UiState,
    onUpdateTodo: (Todo) -> Unit
) {
    when(uiState) {
        is UpdateTodoViewModel.UiState.Loading -> {
            LoadingUi(modifier = modifier)
        }
        is UpdateTodoViewModel.UiState.Success -> {
            UpdateTodoContent(
                modifier = modifier,
                todo = uiState.todo,
                onUpdateTodo = onUpdateTodo
            )
        }
        is UpdateTodoViewModel.UiState.Error -> {
            ErrorUi(modifier = modifier)
        }
    }
}

@Composable
private fun UpdateTodoContent(
    modifier: Modifier = Modifier,
    todo: Todo,
    onUpdateTodo: (Todo) -> Unit
) {

}

@Composable
private fun LoadingUi(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Loading...",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun ErrorUi(
    modifier: Modifier = Modifier,
    message: String = stringResource(Res.string.something_went_wrong),
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "⚠️",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}