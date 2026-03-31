package com.sampe.cmp.app.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface MainNavKey: NavKey {

    @Serializable
    data object HomeScreen : MainNavKey

    @Serializable
    data class EditTodoScreen(val id: Long) : MainNavKey

}