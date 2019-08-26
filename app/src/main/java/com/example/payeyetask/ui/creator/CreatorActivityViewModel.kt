package com.example.payeyetask.ui.creator

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.payeyetask.model.Employee
import com.example.payeyetask.model.Gender
import com.example.payeyetask.ui.base.BaseViewModel
import com.example.payeyetask.utils.FormValidator
import com.example.payeyetask.view.AddressForm
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class CreatorActivityViewModel(
    application: Application,
    private val repository: CreatorActivityRepository
) : BaseViewModel(application) {
    val addressForms = mutableListOf<AddressForm>()
    val formValidator = MutableLiveData<Boolean>()

    fun saveEmployee(name: String, surname: String, age: String, gender: Gender) =
        viewModelScope.launch {
            if(!FormValidator.validateForm(name, surname, age, addressForms)) {
                formValidator.postValue(false)
                return@launch
            } else
                formValidator.postValue(true)
            val employeeId = repository.saveEmployee(Employee(name, surname, Integer.parseInt(age), gender))
            val addresses = addressForms.map { addressForm -> addressForm.getAddressObject() }
            addresses.map { address ->
                address?.let {
                    address.employeeId = employeeId
                    repository.saveAddress(address)
                }
            }
        }
}