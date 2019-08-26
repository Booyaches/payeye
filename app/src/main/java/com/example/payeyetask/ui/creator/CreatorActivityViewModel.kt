package com.example.payeyetask.ui.creator

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.payeyetask.model.Employee
import com.example.payeyetask.model.Gender
import com.example.payeyetask.ui.base.BaseViewModel
import com.example.payeyetask.view.AddressForm
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class CreatorActivityViewModel(
    application: Application,
    private val repository: CreatorActivityRepository
) : BaseViewModel(application) {
    val addressForms = mutableListOf<AddressForm>()

    fun saveEmployee(name: String, surname: String, age: Int, gender: Gender) =
        viewModelScope.launch {
            val employeeId = repository.saveEmployee(Employee(name, surname, age, gender))
            val addresses = addressForms.map { addressForm -> addressForm.getAddressObject() }
            addresses.map { address ->
                address?.let {
                    address.employeeId = employeeId
                    repository.saveAddress(address)
                }
            }
        }
}