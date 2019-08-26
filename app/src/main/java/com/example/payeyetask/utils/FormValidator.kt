package com.example.payeyetask.utils

import com.example.payeyetask.view.AddressForm

class FormValidator {
    companion object {
        fun validateForm(name: String, surname: String, age: String, addressForms: List<AddressForm>) : Boolean {
            val formsValid = if(addressForms.isEmpty())
                true
            else
                addressForms.any { form -> form.isFormValid() }
            return !name.isNullOrBlank() && !surname.isNullOrBlank() && !age.isNullOrBlank() && formsValid
        }
    }
}