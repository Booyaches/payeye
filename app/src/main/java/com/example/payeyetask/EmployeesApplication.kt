package com.example.payeyetask

import android.app.Application
import com.example.payeyetask.di.KoinModule
import org.koin.android.ext.android.startKoin

open class EmployeesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val modules = KoinModule()
        startKoin(
            this@EmployeesApplication,
            listOf(
                modules.persistenceModule,
                modules.dashboardModule,
                modules.addEmployeeModule,
                modules.editEmployeeModule
            )
        )
    }
}