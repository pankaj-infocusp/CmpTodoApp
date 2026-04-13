package com.sampe.cmp.app.ui.compose.features.todo.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.enums.TodoColors
import com.sampe.cmp.app.utils.DateTimeUtils
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.painterResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.ic_add_icon
import sampecmpapp.composeapp.generated.resources.ic_delete_icon
import kotlin.time.Clock

@Composable
fun TodoScreen(
    modifier: Modifier = Modifier,
    isSinglePane: Boolean,
    todos: List<Todo>,
    onItemClick: (Long) -> Unit,
    onCreateTodo: (Todo) -> Unit,
    onComplete: (Todo) -> Unit,
    onDelete: (Long) -> Unit
) {
    TodoScaffold(
        modifier = modifier,
        isSinglePane = isSinglePane,
        todos = todos,
        onItemClick = onItemClick,
        onCreateTodo = onCreateTodo,
        onComplete = onComplete,
        onDelete = onDelete
    )
}

@Composable
private fun TodoScaffold(
    modifier: Modifier = Modifier,
    isSinglePane: Boolean,
    todos: List<Todo>,
    onItemClick: (Long) -> Unit,
    onCreateTodo: (Todo) -> Unit,
    onComplete: (Todo) -> Unit,
    onDelete: (Long) -> Unit
) {

    if (isSinglePane) {
        SinglePanDeviceScaffold(
            modifier = modifier.fillMaxSize(),
            todos = todos,
            onCreateTodo = onCreateTodo,
            onItemClick = onDelete,
            onComplete = onComplete,
            onDelete = onDelete
        )
    } else {
        /*MultiPanDeviceScaffold(
            modifier = modifier.fillMaxSize(),
            todos = todos,
            onCreateTodo = onCreateTodo
        )*/
        SinglePanDeviceScaffold(
            modifier = modifier.fillMaxSize(),
            todos = todos,
            onCreateTodo = onCreateTodo,
            onItemClick = onItemClick,
            onComplete = onComplete,
            onDelete = onDelete
        )
    }
}

@Composable
private fun SinglePanDeviceScaffold(
    modifier: Modifier = Modifier,
    todos: List<Todo>,
    onCreateTodo: (Todo) -> Unit,
    onDelete: (Long) -> Unit,
    onItemClick: (Long) -> Unit,
    onComplete: (Todo) -> Unit
) {
    val colorList = TodoColors.entries.map { it.value }.toImmutableList()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onCreateTodo.invoke(
                    Todo(
                        title = "New Todo",
                        body = "New Todo Body",
                        color = colorList.random().toArgb(),
                        createdAt = Clock.System.now().toEpochMilliseconds(),
                        updatedAt = null
                    )
                ) },
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_add_icon),
                        contentDescription = "Add"
                    )
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier.fillMaxWidth()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                items = todos,
                key = { item -> item.id},
                itemContent = { item ->
                    TodoItem(
                        item = item,
                        onItemClick = onItemClick,
                        onComplete = onComplete,
                        onDelete = onDelete
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
private fun MultiPanDeviceScaffold(
    modifier: Modifier = Modifier,
    todos: List<Todo>,
    onCreateTodo: (Todo) -> Unit
) {
    val scrollState = rememberScrollState()
    val navigator = rememberListDetailPaneScaffoldNavigator<Nothing>()
}

@Composable
private fun TodoItem(
    modifier: Modifier = Modifier,
    item: Todo,
    onItemClick: (Long) -> Unit,
    onComplete: (Todo) -> Unit,
    onDelete: (Long) -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(74.dp)
            .clickable { onItemClick(item.id) },
        colors = CardDefaults.cardColors(
            containerColor = Color(item.color)
        )
    ) {
        Row {
            RadioButton(
                modifier = Modifier
                    .fillMaxHeight(),
                selected = item.isCompleted,
                onClick = { onComplete.invoke(item.copy(isCompleted = true)) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.White,
                    unselectedColor = Color.White
                )
            )
            Column(
                modifier = Modifier.fillMaxHeight()
                    .fillMaxWidth().weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = Color.White
                )
                Text(
                    text = DateTimeUtils.getRelativeTime(item.createdAt),
                    style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = Color.White
                )
            }
            IconButton(
                onClick = { onDelete.invoke(item.id) },
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_delete_icon),
                        contentDescription = "Delete",
                        tint = Color.White
                    )
                },
                modifier = Modifier.fillMaxHeight(),
            )
        }
    }
}

@Composable
@Preview
private fun TodoListPreview() {
    TodoScreen(
        isSinglePane = true,
        todos = listOf(
            Todo(
                title = "New Todo",
                body = "New Todo Body",
                color = TodoColors.RED.value.toArgb(),
                createdAt = Clock.System.now().toEpochMilliseconds(),
                updatedAt = null
            )
        ),
        onItemClick = {},
        onCreateTodo = {},
        onComplete = {},
        onDelete = {}
    )
}