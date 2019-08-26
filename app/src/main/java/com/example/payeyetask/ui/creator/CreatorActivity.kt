package com.example.payeyetask.ui.creator

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.payeyetask.R
import com.example.payeyetask.model.Gender
import com.example.payeyetask.ui.base.BaseActivity
import com.example.payeyetask.view.AddressForm
import kotlinx.android.synthetic.main.activity_editor.*
import org.koin.android.ext.android.inject

class CreatorActivity : BaseActivity<EditorActivityViewModel>(){
    override val layoutId = R.layout.activity_editor
    override val viewModel: EditorActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSpinner()
        initListeners()
    }

    private fun initListeners(){
        btn_add_address.setOnClickListener { addAddressForm() }
        btn_save.setOnClickListener { saveEmployee() }
    }

    private fun initSpinner() = ArrayAdapter.createFromResource(
        this,
        R.array.gender_array,
        android.R.layout.simple_spinner_item
    ).also { adapter ->
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_gender.adapter = adapter
    }

    private fun addAddressForm(){
        val addressForm = AddressForm(this)
        ll_addresses.addView(addressForm)
        viewModel.addressForms.add(addressForm)
        scroll_view.fullScroll(View.FOCUS_DOWN)
    }

    private fun saveEmployee(){
        viewModel.saveEmployee(
            et_name.editableText.toString(),
            et_surname.editableText.toString(),
            Integer.parseInt(et_age.editableText.toString()),
            Gender.values()[spinner_gender.selectedItemPosition]
        )
        this.finish()
    }

    override fun bindViewHolder() {

    }
}
