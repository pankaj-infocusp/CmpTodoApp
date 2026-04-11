package com.sampe.cmp.app.navigation.navgraph.home

import androidx.navigation3.runtime.EntryProviderScope
import com.sampe.cmp.app.features.todo.ui.TodoScreen
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.HomeDestination
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.navigation.navcontroller.NavGraph

internal class HomeNavGraph: NavGraph {
    override val navGraph: EntryProviderScope<Destination>.(NavEventController) -> Unit
        get() = { navEventController ->
            entry<HomeDestination.Home> {
                TodoScreen()
            }
        }
}
