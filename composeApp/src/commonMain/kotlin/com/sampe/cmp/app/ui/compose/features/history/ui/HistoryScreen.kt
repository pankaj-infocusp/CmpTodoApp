package com.sampe.cmp.app.ui.compose.features.history.ui

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sampe.cmp.app.database.entity.Todo
import com.sampe.cmp.app.utils.DateTimeUtils
import org.jetbrains.compose.resources.painterResource
import sampecmpapp.composeapp.generated.resources.Res
import sampecmpapp.composeapp.generated.resources.ic_arrow_back
import sampecmpapp.composeapp.generated.resources.ic_delete_icon

@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    isSinglePane: Boolean,
    todos: List<Todo>,
    onDeleteTodo: (id: Long) -> Unit
) {

    HistoryScaffold(
        modifier = modifier,
        isSinglePane = isSinglePane,
        todos = todos,
        onDeleteTodo = onDeleteTodo
    )
}

@Composable
private fun HistoryScaffold(
    modifier: Modifier = Modifier,
    isSinglePane: Boolean,
    todos: List<Todo>,
    onDeleteTodo: (id: Long) -> Unit
) {

    if (isSinglePane) {
        SinglePanDeviceScaffold(
            modifier = modifier,
            todos = todos,
            onDeleteTodo = onDeleteTodo
        )
    } else {
        SinglePanDeviceScaffold(
            modifier = modifier,
            todos = todos,
            onDeleteTodo = onDeleteTodo
        )
    }
}

@Composable
private fun SinglePanDeviceScaffold(
    modifier: Modifier = Modifier,
    todos: List<Todo>,
    onDeleteTodo: (id: Long) -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
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
                    TodoHistoryItem(
                        item = item,
                        onDeleteTodo = onDeleteTodo
                    )
                }
            )
        }
    }
}

@Composable
private fun TodoHistoryItem(
    modifier: Modifier = Modifier,
    item: Todo,
    onDeleteTodo: (Long) -> Unit
) {
    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(74.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(item.color)
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
            Column(
                modifier = Modifier.fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f),
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
                onClick = { onDeleteTodo.invoke(item.id) },
                content = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_delete_icon),
                        contentDescription = "Delete Todo",
                        tint = Color.White
                    )
                },
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
private fun MultiPanDeviceScaffold(
    todos: List<Todo>,
    onDeleteTodo: (id: Long) -> Unit
) {

}