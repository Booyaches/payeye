package com.example.payeyetask.ui.editor

import android.app.Application
import com.example.payeyetask.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher

class EditorActivityViewModel(
    application: Application,
    private val repository: EditorActivityRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : BaseViewModel(application, coroutineDispatcher) {



}