package com.example.payeyetask.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.payeyetask.model.Employee

@Dao
interface EmployeeDAO {

    @Insert
    suspend fun addNewEmployee(employee: Employee) : Long

    @Query("SELECT * from employee where id = :id")
    suspend fun getEmployeeById(id: Long): Employee?

    @Query("SELECT * from employee")
    suspend fun getAllEmployees(): List<Employee>
}