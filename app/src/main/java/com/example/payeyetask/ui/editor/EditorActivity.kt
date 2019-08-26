package com.example.payeyetask.ui.creator

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import com.example.payeyetask.model.Address
import com.example.payeyetask.model.Gender
import com.example.payeyetask.ui.base.FormActivity
import com.example.payeyetask.utils.KEY_EMPLOYEE_ID
import com.example.payeyetask.view.AddressForm
import kotlinx.android.synthetic.main.activity_editor.*
import org.koin.android.ext.android.inject

class EditorActivity : FormActivity<EditorActivityViewModel>(){
    override val viewModel: EditorActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSpinner()
        initListeners()
        initEditorFields()
        btn_delete.visibility = VISIBLE
    }

    private fun initEditorFields(){
        if(intent.hasExtra(KEY_EMPLOYEE_ID)){
            viewModel.getEmployeeData(intent.getLongExtra(KEY_EMPLOYEE_ID, -1))
        } else this.finish()
    }

    private fun initListeners(){
        btn_add_address.setOnClickListener { addAddressForm(null) }
        btn_save.setOnClickListener { updateEmployee() }
        btn_delete.setOnClickListener { viewModel.deleteEmployee() }
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
        viewModel.formValidator.observe(this, Observer {
            if (!it) {
                showFormInvalidDialog()
            } else {
                this.finish()
            }
        })
        viewModel.deleteEmployee.observe(this, Observer {
            this.finish()
        })
    }

    private fun addAddressForm(address: Address?){
        val addressForm = AddressForm(this)
        ll_addresses.addView(addressForm)
        address?.let { addressForm.setAddress(it) }
        viewModel.addressForms.add(addressForm)
        scroll_view.fullScroll(View.FOCUS_DOWN)
    }

    private fun updateEmployee(){
        viewModel.updateEmployee(
            et_name.editableText.toString(),
            et_surname.editableText.toString(),
            et_age.editableText.toString(),
            Gender.values()[spinner_gender.selectedItemPosition]
        )
    }
}
