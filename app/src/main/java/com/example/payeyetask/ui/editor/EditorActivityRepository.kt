package com.example.payeyetask.ui.creator

import com.example.payeyetask.model.Employee
import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.ui.base.BaseRepository

class EditorActivityRepository(database: EmployeeDatabase) : BaseRepository(database){
    private val employeeDao = database.employeeDao()

    suspend fun getEmployee(id: Long) = employeeDao.getEmployeeById(id)

    suspend fun saveEmployee(employee: Employee) = employeeDao.addNewEmployee(employee)

}