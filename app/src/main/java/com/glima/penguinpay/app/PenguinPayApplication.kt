package com.glima.penguinpay.app

import android.app.Application
import com.glima.data.di.DataModule
import com.glima.domain.di.DomainModule
import com.glima.penguinpay.di.ApplicationModule
import com.glima.penguinpay.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PenguinPayApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PenguinPayApplication)
            modules(
                listOf(
                    ApplicationModule.module,
                    PresentationModule.module,
                    DataModule.module,
                    DomainModule.module,
                )
            )
        }
    }
}