package com.example.payeyetask

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.payeyetask.model.Employee
import com.example.payeyetask.model.Gender
import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.persistance.dao.EmployeeDAO


import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EmployeeDatabaseTest {

    private lateinit var employeeDao: EmployeeDAO

    @Before
    fun setup() {
        EmployeeDatabase.TEST_MODE = true
        employeeDao = EmployeeDatabase.getDatabase(ApplicationProvider.getApplicationContext<Context>()).employeeDao()
    }

    @Test
    fun should_Insert_Employee_Item() {
        runBlocking {
            val employee = Employee("Wiktor", "Xxxx", 31, Gender.MALE)
            val id = employeeDao.addNewEmployee(employee)
            val employeeTest = employeeDao.getEmployeeById(id)
            assertEquals(employee.name, employeeTest!!.name)
        }
    }

    @After
    fun clearTestRecords(){
        runBlocking { employeeDao.nukeTable() }
    }

}