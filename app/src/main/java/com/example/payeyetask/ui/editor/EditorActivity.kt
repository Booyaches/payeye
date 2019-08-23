package com.example.payeyetask.ui.editor

import com.example.payeyetask.R
import com.example.payeyetask.ui.base.BaseActivity
import org.koin.android.ext.android.inject

class EditorActivity : BaseActivity<EditorActivityViewModel>(){
    override val layoutId = R.layout.activity_editor
    override val viewModel: EditorActivityViewModel by inject()

    override fun bindViewHolder() {

    }
}
