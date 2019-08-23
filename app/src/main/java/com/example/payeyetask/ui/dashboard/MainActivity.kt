package com.example.payeyetask.ui.dashboard

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.payeyetask.R
import com.example.payeyetask.ui.base.BaseActivity
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<MainActivityViewModel>() {
    override val layoutId = R.layout.activity_main
    override val viewModel: MainActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun bindViewHolder() {
        viewModel.employees.observe(this, Observer {

        })
    }
}
