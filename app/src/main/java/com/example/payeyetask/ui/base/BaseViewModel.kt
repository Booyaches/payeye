package com.example.payeyetask.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import org.koin.standalone.KoinComponent

abstract class BaseViewModel(application: Application): AndroidViewModel(application), KoinComponent