package com.example.payeyetask.ui.dashboard

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.payeyetask.model.Employee
import com.example.payeyetask.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainActivityViewModel(
    application: Application,
    private val repository: MainActivityRepository
) : BaseViewModel(application) {
    lateinit var employees: LiveData<List<Employee>>

    fun updateEmployees() {
        employees = liveData {
            viewModelScope.launch {
                val employeeList = repository.getAllEmployees()
                emit(employeeList)
            }
        }

    }
}