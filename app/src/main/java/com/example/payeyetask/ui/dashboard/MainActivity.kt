package com.example.payeyetask.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.payeyetask.R
import com.example.payeyetask.ui.base.BaseActivity
import com.example.payeyetask.ui.creator.CreatorActivity
import com.example.payeyetask.ui.creator.EditorActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<MainActivityViewModel>() {
    override val layoutId = R.layout.activity_main
    override val viewModel: MainActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    override fun onResume() {
        viewModel.updateEmployees()
        super.onResume()

    }

    private fun initListeners(){
        fab_add_employee.setOnClickListener {
            val intent = Intent(this, CreatorActivity::class.java)
            startActivity(intent)
        }
    }

    override fun bindViewHolder() {
        viewModel.employees.observe(this, Observer {
            if(it.isNullOrEmpty()) {
                tv_guide_text.visibility = VISIBLE
                rv_employee.visibility = GONE
            } else {
                tv_guide_text.visibility = GONE
                rv_employee.visibility = VISIBLE
                rv_employee.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = EmployeeListAdapter(it, this@MainActivity, onListItemClick)
                }
            }
        })
    }

    private val onListItemClick: (View, Int, Int) -> Unit = { _, i, _ ->

    }
}
