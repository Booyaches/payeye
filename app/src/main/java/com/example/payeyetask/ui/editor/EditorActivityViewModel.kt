package com.example.payeyetask.ui.creator

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.payeyetask.model.Address
import com.example.payeyetask.model.Employee
import com.example.payeyetask.model.Gender
import com.example.payeyetask.ui.base.BaseViewModel
import com.example.payeyetask.view.AddressForm
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class EditorActivityViewModel(
    application: Application,
    private val repository: EditorActivityRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) : BaseViewModel(application, coroutineDispatcher) {

    val addressForms = mutableListOf<AddressForm>()
    val employeeData = MutableLiveData<Employee>()
    val employeeAddresses = MutableLiveData<List<Address>>()

    fun saveEmployee(name: String, surname: String, age: Int, gender: Gender) = viewModelScope.launch {
        val employeeId = repository.saveEmployee(Employee(name, surname, age, gender))
        val addresses = addressForms.map { addressForm -> addressForm.getAddressObject() }
        addresses.map { address -> address?.employeeId = employeeId }
    }

    fun getEmployeeData(id: Long) = viewModelScope.launch {
        val employee = repository.getEmployee(id)
        val addresses = repository.getAddresses(id)
        employeeData.postValue(employee)
        employeeAddresses.postValue(addresses)
    }






}