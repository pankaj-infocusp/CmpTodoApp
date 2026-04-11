package com.sampe.cmp.app.di.navigation

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.entryProvider
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.navigation.navcontroller.NavGraph

internal data class NavGraphProvider(
    private val navEventController: NavEventController,
    private val navGraphs: List<NavGraph>,
) {
    val navigationGraph: (Destination) -> NavEntry<Destination> = entryProvider {
        navGraphs.forEach { navGraph ->
            navGraph.navGraph(this, navEventController)
        }
    }
}
