package com.example.payeyetask.di

import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.ui.dashboard.MainActivityRepository
import com.example.payeyetask.ui.dashboard.MainActivityViewModel
import com.example.payeyetask.ui.editor.EditorActivityRepository
import com.example.payeyetask.ui.editor.EditorActivityViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class KoinModule {

    private val coroutineDispatcher = Dispatchers.IO

    val persistenceModule = module {
        single { EmployeeDatabase.getDatabase(androidContext()) }
    }

    val dashboardModule = module {
        factory { MainActivityRepository(get() as EmployeeDatabase)}
        viewModel { MainActivityViewModel(androidApplication(), get() as MainActivityRepository, coroutineDispatcher) }
    }

    val editorModule = module{
        factory { EditorActivityRepository(get() as EmployeeDatabase)}
        viewModel { EditorActivityViewModel(androidApplication(), get() as EditorActivityRepository, coroutineDispatcher) }
    }

    val editEmployeeModule = module { }
}