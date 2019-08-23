package com.example.payeyetask.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.standalone.KoinComponent

abstract class BaseViewModel(application: Application, val repository: BaseRepository, coroutineDispatcher: CoroutineDispatcher): AndroidViewModel(application), KoinComponent