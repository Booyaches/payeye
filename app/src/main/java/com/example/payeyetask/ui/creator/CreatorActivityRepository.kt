package com.example.payeyetask.ui.creator

import com.example.payeyetask.model.Address
import com.example.payeyetask.model.Employee
import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.ui.base.BaseRepository

class CreatorActivityRepository(database: EmployeeDatabase) : BaseRepository(database){
    private val employeeDao = database.employeeDao()
    private val addressDao = database.addressDao()

    suspend fun saveEmployee(employee: Employee) : Long = employeeDao.addNewEmployee(employee)
    suspend fun saveAddress(address: Address) = addressDao.addAddress(address)

}