package com.sampe.cmp.app.navigation.navcontroller

import androidx.navigation3.runtime.EntryProviderScope
import com.sampe.cmp.app.navigation.main.Destination

interface NavGraph {
    val navGraph: EntryProviderScope<Destination>.(NavEventController) -> Unit
}