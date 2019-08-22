package com.example.payeyetask.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<VIEW_MODEL_TYPE : BaseViewModel> : AppCompatActivity() {
    abstract val viewModel: VIEW_MODEL_TYPE
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }

    override fun onResume() {
        super.onResume()
        bindViewHolder()
    }

    abstract fun bindViewHolder()
}