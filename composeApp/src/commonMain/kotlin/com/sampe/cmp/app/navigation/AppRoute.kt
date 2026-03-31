package com.sampe.cmp.app.navigation

import androidx.navigation3.runtime.NavKey

private const val PREFIX = "root"

sealed class AppRoute(
    val route: String,
    val routePlaceholder: String = route
) {
    data object Todos : AppRoute("$PREFIX/todos")
    data class EditTodo(val id: Long) : AppRoute(
        route = "$PREFIX/editTodo?id=$id",
        routePlaceholder = "$PREFIX/editTodo?id={id}"
    )
}

private typealias Route = NavKey

