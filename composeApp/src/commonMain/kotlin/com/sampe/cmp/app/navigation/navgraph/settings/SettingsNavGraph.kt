package com.sampe.cmp.app.navigation.navgraph.settings

import androidx.navigation3.runtime.EntryProviderScope
import com.sampe.cmp.app.ui.compose.features.settings.ui.SettingsScreen
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.HomeDestination
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.navigation.navcontroller.NavGraph

internal class SettingsNavGraph: NavGraph {
    override val navGraph: EntryProviderScope<Destination>.(NavEventController) -> Unit
        get() = { navEventController ->
            entry<HomeDestination.Settings> {
                SettingsScreen()
            }
        }
}
