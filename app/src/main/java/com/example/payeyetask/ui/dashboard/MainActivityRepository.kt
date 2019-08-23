package com.example.payeyetask.ui.dashboard

import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.ui.base.BaseRepository

class MainActivityRepository(database: EmployeeDatabase) : BaseRepository(database){
    private val employeeDao = database.employeeDao()

    suspend fun getAllEmployees() = employeeDao.getAllEmployees()

}