package com.sampe.cmp.app.navigation.navgraph.favorites

import androidx.navigation3.runtime.EntryProviderScope
import com.sampe.cmp.app.ui.compose.features.favorites.ui.FavoritesScreen
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.HomeDestination
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.navigation.navcontroller.NavGraph

internal class FavoritesNavGraph: NavGraph {
    override val navGraph: EntryProviderScope<Destination>.(NavEventController) -> Unit
        get() = { navEventController ->
            entry<HomeDestination.Favorites> {
                FavoritesScreen()
            }
        }
}
