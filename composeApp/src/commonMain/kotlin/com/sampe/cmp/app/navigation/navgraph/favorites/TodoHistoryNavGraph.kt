package com.sampe.cmp.app.navigation.navgraph.favorites

import androidx.navigation3.runtime.EntryProviderScope
import com.sampe.cmp.app.ui.compose.features.history.ui.HistoryScreen
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.MainDestination
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.navigation.navcontroller.NavGraph

internal class TodoHistoryNavGraph: NavGraph {
    override val navGraph: EntryProviderScope<Destination>.(NavEventController) -> Unit
        get() = { navEventController ->
            entry<MainDestination.HistoryTab> {
                HistoryScreen()
            }
        }
}
