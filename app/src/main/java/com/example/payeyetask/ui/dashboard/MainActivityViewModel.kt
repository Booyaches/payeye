package com.example.payeyetask.ui.dashboard

import android.app.Application
import com.example.payeyetask.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher

class MainActivityViewModel(
    application: Application,
    repository: MainActivityRepository,
    coroutineDispatcher: CoroutineDispatcher
) : BaseViewModel(application, coroutineDispatcher) {


}