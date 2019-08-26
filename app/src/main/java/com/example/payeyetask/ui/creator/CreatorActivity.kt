package com.example.payeyetask.ui.creator

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.payeyetask.R
import com.example.payeyetask.model.Gender
import com.example.payeyetask.ui.base.BaseActivity
import com.example.payeyetask.ui.base.FormActivity
import com.example.payeyetask.view.AddressForm
import kotlinx.android.synthetic.main.activity_editor.*
import org.koin.android.ext.android.inject

class CreatorActivity : FormActivity<CreatorActivityViewModel>() {
    override val layoutId = R.layout.activity_editor
    override val viewModel: CreatorActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSpinner()
        initListeners()
    }

    private fun initListeners() {
        btn_add_address.setOnClickListener { addAddressForm() }
        btn_save.setOnClickListener { saveEmployee() }
    }

    private fun addAddressForm() {
        val addressForm = AddressForm(this)
        ll_addresses.addView(addressForm)
        viewModel.addressForms.add(addressForm)
        scroll_view.fullScroll(View.FOCUS_DOWN)
    }

    private fun saveEmployee() {
        viewModel.saveEmployee(
            et_name.editableText.toString(),
            et_surname.editableText.toString(),
            et_age.editableText.toString(),
            Gender.values()[spinner_gender.selectedItemPosition]
        )
    }

    override fun bindViewHolder() {
        viewModel.formValidator.observe(this, Observer {
            if (!it) {
                showFormInvalidDialog()
            } else {
                this.finish()
            }
        })
    }
}
