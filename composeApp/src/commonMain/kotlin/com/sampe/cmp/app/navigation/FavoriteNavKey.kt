package com.sampe.cmp.app.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface FavoriteNavKey: NavKey {

    @Serializable
    data object FavoritesScreen : FavoriteNavKey


}