package com.sampe.cmp.app.ui.compose.features.todo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.ui.compose.features.todo.viewmodel.UpdateTodoViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.delete_todo
import sampecmpapp.composeapp.generated.resources.description
import sampecmpapp.composeapp.generated.resources.edit_todo
import sampecmpapp.composeapp.generated.resources.ic_arrow_back
import sampecmpapp.composeapp.generated.resources.loading
import sampecmpapp.composeapp.generated.resources.something_went_wrong
import sampecmpapp.composeapp.generated.resources.title

@Composable
fun UpdateTodoScreen(
    modifier: Modifier = Modifier,
    uiState: UpdateTodoViewModel.UiState,
    onTitleChange: (Long, String) -> Unit,
    onDescriptionChange: (Long, String) -> Unit,
    onDeleteClick: (Long) -> Unit,
    onBackClick: () -> Unit
) {
    when(uiState) {
        is UpdateTodoViewModel.UiState.Loading -> {
            LoadingUi(modifier = modifier)
        }
        is UpdateTodoViewModel.UiState.Success -> {
            UpdateTodoUi(
                modifier = modifier,
                todo = uiState.todo,
                onTitleChange = onTitleChange,
                onDescriptionChange = onDescriptionChange,
                onDeleteClick = onDeleteClick,
                onBackClick = onBackClick
            )
        }
        is UpdateTodoViewModel.UiState.Error -> {
            ErrorUi(modifier = modifier)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UpdateTodoUi(
    modifier: Modifier = Modifier,
    todo: Todo,
    onTitleChange: (Long, String) -> Unit,
    onDescriptionChange: (Long, String) -> Unit,
    onDeleteClick: (Long) -> Unit,
    onBackClick: () -> Unit
) {

    val title = remember { mutableStateOf(todo.title) }
    val body = remember { mutableStateOf(todo.body) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(Res.string.edit_todo)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomActionButtons(
                onDeleteClick = {
                    onDeleteClick.invoke(todo.id)
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {

            OutlinedTextField(
                value = title.value,
                onValueChange = {
                    title.value = it
                    onTitleChange.invoke(todo.id, it)
                },
                label = { Text(text = stringResource(Res.string.title)) },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = body.value,
                onValueChange = {
                    body.value = it
                    onDescriptionChange.invoke(todo.id, it)
                },
                label = { Text(text = stringResource(Res.string.description)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                maxLines = 5
            )
        }
    }
}

@Composable
fun BottomActionButtons(
    onDeleteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = onDeleteClick,
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            )
        ) {
            Text(text = stringResource(Res.string.delete_todo))
        }
    }
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
            text = stringResource(Res.string.loading),
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