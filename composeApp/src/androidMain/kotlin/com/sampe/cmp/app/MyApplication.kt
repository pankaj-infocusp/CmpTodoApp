package com.sampe.cmp.app

import android.app.Application
import com.sampe.cmp.app.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApplication)
        }
    }
}