package com.sampe.cmp.app.navigation.navgraph.home

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.scene.DialogSceneStrategy
import com.sampe.cmp.app.extension.isSinglePane
import com.sampe.cmp.app.navigation.events.Event
import com.sampe.cmp.app.navigation.events.TodoEvent
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.MainDestination
import com.sampe.cmp.app.navigation.main.TodoDestination
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.navigation.navcontroller.NavGraph
import com.sampe.cmp.app.ui.compose.features.todo.ui.AddTodoBottomSheet
import com.sampe.cmp.app.ui.compose.features.todo.ui.TodoScreen
import com.sampe.cmp.app.ui.compose.features.todo.ui.UpdateTodoScreen
import com.sampe.cmp.app.ui.compose.features.todo.viewmodel.AddTodoViewModel
import com.sampe.cmp.app.ui.compose.features.todo.viewmodel.TodoViewModel
import com.sampe.cmp.app.ui.compose.features.todo.viewmodel.UpdateTodoViewModel
import org.koin.compose.viewmodel.koinViewModel

internal class TodoTabNavGraph: NavGraph {
    override val navGraph: EntryProviderScope<Destination>.(NavEventController) -> Unit
        get() = { navEventController ->
            entry<MainDestination.TodoTab> {
                val viewModel: TodoViewModel = koinViewModel()
                val todos by viewModel.todos.collectAsStateWithLifecycle()
                TodoScreen(
                    isSinglePane = currentWindowAdaptiveInfo().windowSizeClass.isSinglePane(),
                    todos = todos,
                    onItemClick = { id ->
                        navEventController.sendEvent(TodoEvent.OnUpdateTodoClick(id))
                    },
                    onCreateTodo = {
                        navEventController.sendEvent(TodoEvent.OnTodoCreateClick)
                    },
                    onComplete = { todo ->
                        viewModel.onTodoCompleted(todo)
                    }
                )
            }

            entry<TodoDestination.UpdateTodo> { entry ->
                val viewModel: UpdateTodoViewModel = koinViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                LaunchedEffect(Unit) {
                    viewModel.getTodoById(entry.todoId)
                }

                UpdateTodoScreen(
                    uiState = uiState,
                    onTitleChange = { id, title ->
                        viewModel.updateTitle(id, title)
                    },
                    onDescriptionChange = { id, body ->
                        viewModel.updateBody(id, body)
                    },
                    onDeleteClick = { id ->
                        viewModel.deleteTodo(id)
                    },
                    onBackClick = {
                        navEventController.sendEvent(Event.OnBack)
                    }
                )
            }

            entry<TodoDestination.AddTodoBottomSheet>(
                metadata = DialogSceneStrategy.dialog()
            ) {
                val viewModel: AddTodoViewModel = koinViewModel()
                AddTodoBottomSheet(
                    onDismiss = {
                        navEventController.sendEvent(Event.OnBack)
                    },
                    onCreateTodo = { title, color ->
                        viewModel.addTodo(title, color)
                    }
                )
            }
        }
}
