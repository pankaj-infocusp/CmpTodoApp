package com.sampe.cmp.app.di.repository

import com.sampe.cmp.app.data.implementation.TaskRepositoryImpl
import com.sampe.cmp.app.domain.repository.TaskRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import kotlin.coroutines.EmptyCoroutineContext.get

val repositoryModule = module {
    singleOf(::TaskRepositoryImpl) bind TaskRepository::class
}