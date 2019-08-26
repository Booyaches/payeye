package com.example.payeyetask.view

import android.content.Context
import android.text.SpannableStringBuilder
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.payeyetask.R
import com.example.payeyetask.model.Address
import com.google.android.material.textfield.TextInputEditText

class AddressForm @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    lateinit var streetEt: TextInputEditText
    lateinit var buildingEt: TextInputEditText
    lateinit var apartamentEt: TextInputEditText
    lateinit var zipEt: TextInputEditText
    lateinit var cityEt: TextInputEditText

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.custom_address_form, this, true)
        orientation = VERTICAL

        findViews()
    }

    private fun findViews() {
        streetEt = findViewById(R.id.et_stree)
        buildingEt = findViewById(R.id.et_building)
        apartamentEt = findViewById(R.id.et_apartament)
        zipEt = findViewById(R.id.et_zip)
        cityEt = findViewById(R.id.et_city)
    }


    fun getAddressObject(): Address? {
        return Address(
            streetEt.editableText.toString(),
            Integer.parseInt(buildingEt.editableText.toString()),
            Integer.parseInt(apartamentEt.editableText.toString()),
            cityEt.editableText.toString(),
            zipEt.editableText.toString(), null
        )
    }

    fun setAddress(address: Address) {
        streetEt.text = SpannableStringBuilder(address.street)
        buildingEt.text = SpannableStringBuilder(address.building.toString())
        apartamentEt.text = SpannableStringBuilder(address.apartmentNo.toString())
        zipEt.text = SpannableStringBuilder(address.zipCode)
        cityEt.text = SpannableStringBuilder(address.city)
    }

    fun isFormValid() = !streetEt.text.isNullOrBlank() &&
            !buildingEt.text.isNullOrBlank() &&
            !apartamentEt.text.isNullOrBlank() &&
            !zipEt.text.isNullOrBlank() &&
            !cityEt.text.isNullOrBlank()

}