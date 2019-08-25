package com.example.payeyetask.ui.editor

import com.example.payeyetask.model.Employee
import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.ui.base.BaseRepository

class EditorActivityRepository(database: EmployeeDatabase) : BaseRepository(database){
    private val employeeDao = database.employeeDao()

    suspend fun saveEmployee(employee: Employee) : Long = employeeDao.addNewEmployee(employee)

}