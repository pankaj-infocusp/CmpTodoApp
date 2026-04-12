package com.sampe.cmp.app.di

import com.sampe.cmp.app.di.coroutine.coroutinesModule
import com.sampe.cmp.app.di.navigation.bottomBarModule
import com.sampe.cmp.app.di.navigation.navigationModule
import com.sampe.cmp.app.di.repository.repositoryModule
import com.sampe.cmp.app.di.room.roomModule
import com.sampe.cmp.app.di.viewmodel.viewModelModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

expect fun roomBuilderModule(): Module

fun initKoin(
    config: KoinAppDeclaration? = null,
    appModule: Module = module { }
) {
    startKoin {
        config?.invoke(this)
        modules(appModules + appModule)
    }
}

internal val appModules = listOf(
    coroutinesModule,
    navigationModule,
    bottomBarModule,
    roomBuilderModule(),
    roomModule,
    repositoryModule,
    viewModelModule
)