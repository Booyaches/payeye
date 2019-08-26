package com.example.payeyetask.ui.creator

import com.example.payeyetask.model.Employee
import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.ui.base.BaseRepository

class CreatorActivityRepository(database: EmployeeDatabase) : BaseRepository(database){
    private val employeeDao = database.employeeDao()

    suspend fun saveEmployee(employee: Employee) : Long = employeeDao.addNewEmployee(employee)

}