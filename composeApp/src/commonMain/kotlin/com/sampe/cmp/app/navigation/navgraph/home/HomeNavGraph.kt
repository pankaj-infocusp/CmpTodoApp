package com.sampe.cmp.app.navigation.navgraph.home

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.EntryProviderScope
import com.sampe.cmp.app.extension.isSinglePane
import com.sampe.cmp.app.ui.compose.features.todo.ui.TodoScreen
import com.sampe.cmp.app.ui.compose.features.todo.viewmodel.TodoViewModel
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.HomeDestination
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.navigation.navcontroller.NavGraph
import org.koin.compose.viewmodel.koinViewModel

internal class HomeNavGraph: NavGraph {
    override val navGraph: EntryProviderScope<Destination>.(NavEventController) -> Unit
        get() = { navEventController ->
            entry<HomeDestination.Home> {
                val viewModel: TodoViewModel = koinViewModel()
                val todos by viewModel.todos.collectAsStateWithLifecycle()
                TodoScreen(
                    isSinglePane = currentWindowAdaptiveInfo().windowSizeClass.isSinglePane(),
                    todos = todos,
                    onCreateTodo = { todo ->
                        viewModel.addTodo(todo)
                    },
                    onDelete = { id ->
                        viewModel.deleteTodo(id)
                    }
                )
            }
        }
}
