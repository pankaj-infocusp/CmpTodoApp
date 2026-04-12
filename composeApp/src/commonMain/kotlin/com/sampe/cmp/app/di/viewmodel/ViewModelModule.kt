package com.sampe.cmp.app.di.viewmodel

import com.sampe.cmp.app.domain.usecase.AddTodoUseCase
import com.sampe.cmp.app.domain.usecase.DeleteTodoUseCase
import com.sampe.cmp.app.domain.usecase.GetAllTodosUseCase
import com.sampe.cmp.app.ui.compose.features.todo.viewmodel.TodoViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    // UseCases
    singleOf(::AddTodoUseCase)
    singleOf(::GetAllTodosUseCase)
    singleOf(::DeleteTodoUseCase)

    //ViewModel provider
    viewModelOf(::TodoViewModel)
}