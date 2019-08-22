package com.example.payeyetask.di

import com.example.payeyetask.persistance.EmployeeDatabase
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

class KoinModule {

    private val coroutineDispatcher = Dispatchers.IO

    val persistenceModule = module {
        single { EmployeeDatabase.getDatabase(androidContext()) }
    }

    val dashboardModule = module { }

    val addEmployeeModule = module{ }

    val editEmployeeModule = module { }
}