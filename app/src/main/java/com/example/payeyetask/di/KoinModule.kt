package com.example.payeyetask.di

import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.ui.creator.CreatorActivityRepository
import com.example.payeyetask.ui.creator.CreatorActivityViewModel
import com.example.payeyetask.ui.dashboard.MainActivityRepository
import com.example.payeyetask.ui.dashboard.MainActivityViewModel
import com.example.payeyetask.ui.creator.EditorActivityRepository
import com.example.payeyetask.ui.creator.EditorActivityViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

class KoinModule {

    val persistenceModule = module {
        single { EmployeeDatabase.getDatabase(androidContext()) }
    }

    val dashboardModule = module {
        factory { MainActivityRepository(get() as EmployeeDatabase)}
        viewModel { MainActivityViewModel(androidApplication(), get() as MainActivityRepository) }
    }

    val creatorModule = module{
        factory { CreatorActivityRepository(get() as EmployeeDatabase) }
        viewModel { CreatorActivityViewModel(androidApplication(), get() as CreatorActivityRepository) }
    }

    val editorModule = module{
        factory { EditorActivityRepository(get() as EmployeeDatabase)}
        viewModel { EditorActivityViewModel(androidApplication(), get() as EditorActivityRepository) }
    }

}