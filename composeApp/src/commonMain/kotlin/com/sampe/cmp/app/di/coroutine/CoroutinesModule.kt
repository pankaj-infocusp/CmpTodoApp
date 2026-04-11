package com.sampe.cmp.app.di.coroutine

import com.sampe.cmp.app.coroutine.AppCoroutineScope
import com.sampe.cmp.app.coroutine.CoroutineDebouncer
import com.sampe.cmp.app.coroutine.CoroutineDebouncerImpl
import com.sampe.cmp.app.coroutine.CoroutineDispatcherProvider
import com.sampe.cmp.app.coroutine.CoroutineDispatcherProviderImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Coroutines library dependency injection module.
 */
val coroutinesModule = module {
    single { AppCoroutineScope() }
    factoryOf(::CoroutineDebouncerImpl) bind CoroutineDebouncer::class
    factoryOf(::CoroutineDispatcherProviderImpl) bind CoroutineDispatcherProvider::class
}
