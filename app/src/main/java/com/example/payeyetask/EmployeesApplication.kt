package com.example.payeyetask

import android.app.Application
import com.example.payeyetask.di.KoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class EmployeesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val modules = KoinModule()
        startKoin {
            androidContext(this@EmployeesApplication)
            modules(
                listOf(
                    modules.dashboardModule,
                    modules.creatorModule,
                    modules.editorModule,
                    modules.persistenceModule
                )
            )
        }
    }
}