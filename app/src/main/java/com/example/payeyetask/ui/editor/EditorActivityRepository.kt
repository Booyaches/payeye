package com.example.payeyetask.ui.creator

import com.example.payeyetask.model.Address
import com.example.payeyetask.model.Gender
import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.ui.base.BaseRepository

class EditorActivityRepository(database: EmployeeDatabase) : BaseRepository(database){
    private val employeeDao = database.employeeDao()
    private val addressDao = database.addressDao()

    suspend fun getEmployee(id: Long) = employeeDao.getEmployeeById(id)
    suspend fun getAddresses(employeeId: Long) = addressDao.getEmployeesAddresses(employeeId)
    suspend fun updateEmployee(id: Long, name: String, surname: String, age: Int, gender: Gender) = employeeDao.updateEmployee(id, name, surname, age, gender)
    suspend fun removeAllEmployeeAddresses(employeeId : Long) = addressDao.removeAllAddressesForId(employeeId)
    suspend fun saveAddress(address: Address) = addressDao.addAddress(address)



}