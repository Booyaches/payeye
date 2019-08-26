package com.example.payeyetask.ui.creator

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.example.payeyetask.R
import com.example.payeyetask.model.Address
import com.example.payeyetask.model.Gender
import com.example.payeyetask.ui.base.BaseActivity
import com.example.payeyetask.utils.KEY_EMPLOYEE_ID
import com.example.payeyetask.view.AddressForm
import kotlinx.android.synthetic.main.activity_editor.*
import org.koin.android.ext.android.inject

class EditorActivity : BaseActivity<EditorActivityViewModel>(){
    override val layoutId = R.layout.activity_editor
    override val viewModel: EditorActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSpinner()
        initListeners()
        initEditorFields()
    }

    private fun initEditorFields(){
        if(intent.hasExtra(KEY_EMPLOYEE_ID)){
            viewModel.getEmployeeData(intent.getLongExtra(KEY_EMPLOYEE_ID, -1))
        } else this.finish()
    }

    private fun initListeners(){
        btn_add_address.setOnClickListener {  }
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

    override fun bindViewHolder() {
        viewModel.employeeData.observe(this, Observer {
            et_name.text = SpannableStringBuilder(it.name)
            et_surname.text = SpannableStringBuilder(it.surname)
            et_age.text = SpannableStringBuilder(it.age.toString())
            spinner_gender.setSelection(it.gender.ordinal)
        })
        viewModel.employeeAddresses.observe(this, Observer {
            it.forEach{address -> addAddressForm(address)}

        })
    }

    private fun addAddressForm(address: Address){
        val addressForm = AddressForm(this)
        ll_addresses.addView(addressForm)
        addressForm.setAddress(address)
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


}
