package com.sampe.cmp.app.navigation.navgraph.favorites

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.EntryProviderScope
import com.sampe.cmp.app.extension.isSinglePane
import com.sampe.cmp.app.ui.compose.features.history.ui.HistoryScreen
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.MainDestination
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.navigation.navcontroller.NavGraph
import com.sampe.cmp.app.ui.compose.features.history.viewmodel.TodoHistoryViewModel
import org.koin.compose.viewmodel.koinViewModel

internal class TodoHistoryNavGraph: NavGraph {
    override val navGraph: EntryProviderScope<Destination>.(NavEventController) -> Unit
        get() = { navEventController ->
            entry<MainDestination.HistoryTab> {
                val viewModel: TodoHistoryViewModel = koinViewModel()
                val todos by viewModel.completedTodos.collectAsStateWithLifecycle()
                HistoryScreen(
                    isSinglePane = currentWindowAdaptiveInfo().windowSizeClass.isSinglePane(),
                    todos = todos,
                    onDeleteTodo = { id ->
                        viewModel.deleteTodo(id)
                    }
                )
            }
        }
}
