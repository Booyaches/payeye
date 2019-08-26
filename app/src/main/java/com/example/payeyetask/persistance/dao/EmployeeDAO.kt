package com.example.payeyetask.persistance.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.payeyetask.model.Employee
import com.example.payeyetask.model.Gender

@Dao
interface EmployeeDAO {

    @Insert
    suspend fun addNewEmployee(employee: Employee) : Long

    @Query("SELECT * from employee where id = :id")
    suspend fun getEmployeeById(id: Long): Employee?

    @Query("SELECT * from employee")
    suspend fun getAllEmployees(): List<Employee>

    @Query("UPDATE employee SET name = :name , surname = :surname, age = :age, gender = :gender WHERE id = :id")
    suspend fun updateEmployee(id: Long, name: String, surname: String, age: Int, gender: Gender)

    @Delete
    suspend fun deleteEmployee(employee: Employee)

}