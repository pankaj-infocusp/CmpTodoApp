package com.sampe.cmp.app

import android.app.Application
import android.content.Context
import com.sampe.cmp.app.di.initKoin
import org.koin.dsl.module

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            appModule = module {
                single<Context> { this@MyApplication }
            }
        )
    }
}