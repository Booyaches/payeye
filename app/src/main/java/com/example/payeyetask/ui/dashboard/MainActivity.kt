package com.example.payeyetask.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.payeyetask.R
import com.example.payeyetask.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
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
            rv_employee.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = EmployeeListAdapter(it, this@MainActivity, onListItemClick)
            }
        })
    }

    private val onListItemClick: (View, Int, Int) -> Unit = { _, i, _ ->

    }
}
