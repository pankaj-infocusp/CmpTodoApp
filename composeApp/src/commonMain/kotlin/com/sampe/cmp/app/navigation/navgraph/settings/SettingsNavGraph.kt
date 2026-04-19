package com.sampe.cmp.app.navigation.navgraph.settings

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.EntryProviderScope
import com.sampe.cmp.app.navigation.main.Destination
import com.sampe.cmp.app.navigation.main.MainDestination
import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.navigation.navcontroller.NavGraph
import com.sampe.cmp.app.ui.compose.features.settings.ui.SettingsScreen
import com.sampe.cmp.app.ui.compose.features.settings.viewmodel.SettingsViewModel
import org.koin.compose.viewmodel.koinViewModel

internal class SettingsNavGraph: NavGraph {
    override val navGraph: EntryProviderScope<Destination>.(NavEventController) -> Unit
        get() = { navEventController ->
            entry<MainDestination.SettingsTab> {
                val viewModel: SettingsViewModel = koinViewModel()
                val themePref by viewModel.savedTheme.collectAsStateWithLifecycle()
                SettingsScreen(
                    isSinglePan = true, //currentWindowAdaptiveInfo().windowSizeClass.isSinglePane(),
                    themePref = themePref,
                    onPreferenceChanged = { themePref ->
                        viewModel.saveThemePreference(themePref)
                    }
                )
            }
        }
}
