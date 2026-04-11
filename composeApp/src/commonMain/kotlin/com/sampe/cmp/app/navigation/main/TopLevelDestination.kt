package com.sampe.cmp.app.navigation.main

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

interface TopLevelDestination {
    val icon: DrawableResource
    val title: StringResource
}