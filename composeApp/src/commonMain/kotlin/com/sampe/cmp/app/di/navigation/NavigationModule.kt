package com.sampe.cmp.app.di.navigation

import com.sampe.cmp.app.navigation.navcontroller.NavEventController
import com.sampe.cmp.app.navigation.navcontroller.NavEventControllerImpl
import com.sampe.cmp.app.navigation.navcontroller.NavGraph
import com.sampe.cmp.app.navigation.navgraph.favorites.FavoritesNavGraph
import com.sampe.cmp.app.navigation.navgraph.home.HomeNavGraph
import com.sampe.cmp.app.navigation.navgraph.settings.SettingsNavGraph
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val navigationModule = module {
    singleOf(::NavEventControllerImpl) bind NavEventController::class
    single { NavGraphProvider(get(), getAll()) }
}

val bottomBarModule = module {
    factoryOf(::HomeNavGraph) bind NavGraph::class
    factoryOf(::FavoritesNavGraph) bind NavGraph::class
    factoryOf(::SettingsNavGraph) bind NavGraph::class
}