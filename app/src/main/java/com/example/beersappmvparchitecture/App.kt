package com.example.beersappmvparchitecture

import android.app.Application
import com.example.beersappmvparchitecture.data.DataModule
import com.example.beersappmvparchitecture.domain.DomainModule
import com.example.beersappmvparchitecture.presentation.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                PresentationModule.module,
                DomainModule.module,
                DataModule.module
            )
        }
    }
}