package com.sampe.cmp.app.di.viewmodel

import com.sampe.cmp.app.domain.usecase.AddTodoUseCase
import com.sampe.cmp.app.domain.usecase.DeleteTodoUseCase
import com.sampe.cmp.app.domain.usecase.GetAllTodosUseCase
import com.sampe.cmp.app.domain.usecase.GetTodoByIdUseCase
import com.sampe.cmp.app.domain.usecase.TodoHistoryUseCase
import com.sampe.cmp.app.domain.usecase.UpdateBodyUseCase
import com.sampe.cmp.app.domain.usecase.UpdateTitleUseCase
import com.sampe.cmp.app.domain.usecase.UpdateTodoUseCase
import com.sampe.cmp.app.ui.compose.features.history.viewmodel.TodoHistoryViewModel
import com.sampe.cmp.app.ui.compose.features.settings.viewmodel.SettingsViewModel
import com.sampe.cmp.app.ui.compose.features.todo.viewmodel.AddTodoViewModel
import com.sampe.cmp.app.ui.compose.features.todo.viewmodel.TodoViewModel
import com.sampe.cmp.app.ui.compose.features.todo.viewmodel.UpdateTodoViewModel
import com.sampe.cmp.app.ui.compose.main.AppViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    // UseCases
    singleOf(::AddTodoUseCase)
    singleOf(::GetAllTodosUseCase)
    singleOf(::DeleteTodoUseCase)
    singleOf(::GetTodoByIdUseCase)
    singleOf(::UpdateTodoUseCase)
    singleOf(::UpdateTitleUseCase)
    singleOf(::UpdateBodyUseCase)
    singleOf(::TodoHistoryUseCase)

    //ViewModel provider
    viewModelOf(::AppViewModel)
    viewModelOf(::TodoViewModel)
    viewModelOf(::AddTodoViewModel)
    viewModelOf(::UpdateTodoViewModel)
    viewModelOf(::TodoHistoryViewModel)
    viewModelOf(::SettingsViewModel)
}