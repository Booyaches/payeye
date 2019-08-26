package com.example.payeyetask.ui.creator

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.payeyetask.model.Address
import com.example.payeyetask.model.Employee
import com.example.payeyetask.model.Gender
import com.example.payeyetask.ui.base.BaseViewModel
import com.example.payeyetask.utils.FormValidator
import com.example.payeyetask.view.AddressForm
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class EditorActivityViewModel(
    application: Application,
    private val repository: EditorActivityRepository
) : BaseViewModel(application) {
    val addressForms = mutableListOf<AddressForm>()
    val employeeData = MutableLiveData<Employee>()
    val employeeAddresses = MutableLiveData<List<Address>>()
    val formValidator = MutableLiveData<Boolean>()
    val deleteEmployee = MutableLiveData<Void>()

    fun updateEmployee(name: String, surname: String, age: String, gender: Gender) = viewModelScope.launch {
        if(!FormValidator.validateForm(name, surname, age, addressForms)) {
            formValidator.postValue(false)
            return@launch
        } else
            formValidator.postValue(true)
        repository.updateEmployee(employeeData.value?.id!!, name, surname, Integer.parseInt(age), gender)
        repository.removeAllEmployeeAddresses(employeeData.value?.id!!)
        val addresses = addressForms.map { addressForm -> addressForm.getAddressObject() }
        addresses.map { address ->
            address?.let {
                address.employeeId = employeeData.value?.id!!
                repository.saveAddress(address)
            }
        }
    }

    fun getEmployeeData(id: Long) = viewModelScope.launch {
        val employee = repository.getEmployee(id)
        val addresses = repository.getAddresses(id)
        employeeData.postValue(employee)
        employeeAddresses.postValue(addresses)
    }

    fun deleteEmployee() {
        viewModelScope.launch {
            employeeData.value?.let {
                repository.deleteEmployee(it)
                repository.removeAllEmployeeAddresses(it.id!!)
                deleteEmployee.postValue(null)
            }
        }
    }
}