package com.example.payeyetask.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.payeyetask.R
import com.example.payeyetask.model.Address

class AddressForm @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.custom_address_form, this, true)
        orientation = VERTICAL
    }


    fun getAddressObject() : Address? {
         return null
    }

}