package com.example.payeyetask.ui.base

import android.app.AlertDialog
import android.widget.ArrayAdapter
import com.example.payeyetask.R
import kotlinx.android.synthetic.main.activity_editor.*

abstract class FormActivity<VIEW_MODEL_TYPE : BaseViewModel> : BaseActivity<VIEW_MODEL_TYPE>() {

    protected fun initSpinner() = ArrayAdapter.createFromResource(
        this,
        R.array.gender_array,
        android.R.layout.simple_spinner_item
    ).also { adapter ->
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_gender.adapter = adapter
    }

    protected fun showFormInvalidDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.editor_not_error))
        builder.setMessage(getString(R.string.editor_not_valid))
        builder.setPositiveButton(android.R.string.yes, null)
        builder.show()
    }
}