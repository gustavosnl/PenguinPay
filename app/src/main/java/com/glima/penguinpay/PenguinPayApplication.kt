package com.glima.penguinpay

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PenguinPayApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PenguinPayApplication)
            modules(
                listOf(
//                    appModule,
//                    presentationModule,
//                    dataModule,
//                    domainModule
                )
            )
        }
    }
}