package com.example.payeyetask.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.payeyetask.R
import com.example.payeyetask.model.Employee
import com.example.payeyetask.utils.onClick
import kotlinx.android.synthetic.main.item_employees.view.*

class EmployeeListAdapter(
    private val employees: List<Employee>,
    private val context: Context,
    private val itemClickListener: (View, Int, Int) -> Unit
) : RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder>() {

    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val employeeName = view.tv_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val viewHolder = EmployeeViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_employees,
                parent,
                false
            )
        )
        viewHolder.onClick(itemClickListener)
        return viewHolder
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.employeeName.text = "${employees[position].name} ${employees[position].surname}"
    }

    override fun getItemCount() = employees.size


    override fun getItemId(position: Int) = employees[position].id!!

    fun getItemAtPosition(position: Int) = employees[position]

}