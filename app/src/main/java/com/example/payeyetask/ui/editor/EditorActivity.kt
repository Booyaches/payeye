package com.example.payeyetask.ui.editor

import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.payeyetask.R
import com.example.payeyetask.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_editor.*
import org.koin.android.ext.android.inject

class EditorActivity : BaseActivity<EditorActivityViewModel>(){
    override val layoutId = R.layout.activity_editor
    override val viewModel: EditorActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSpinner()
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

    }
}
