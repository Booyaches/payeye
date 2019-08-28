package com.example.payeyetask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.payeyetask.model.Employee
import com.example.payeyetask.model.Gender
import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.persistance.dao.EmployeeDAO
import com.example.payeyetask.ui.dashboard.MainActivityViewModel
import com.jraska.livedata.test
import kotlinx.coroutines.runBlocking

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.AutoCloseKoinTest
import org.koin.test.get

class ViewModelTest : AutoCloseKoinTest() {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var employeeDao: EmployeeDAO

    @Before
    fun setup() {
        employeeDao = (get() as EmployeeDatabase).employeeDao()
    }

    @Test
    fun should_return_multiple_records() {
        runBlocking {
            employeeDao.nukeTable()
            employeeDao.addNewEmployee(Employee("Jan", "Kowalski", 32, Gender.MALE))
            employeeDao.addNewEmployee(Employee("Jan", "Kowalski", 32, Gender.MALE))
        }
        val mainActivityViewModel =  get() as MainActivityViewModel
        mainActivityViewModel.updateEmployees()
        mainActivityViewModel.employees.test()
            .awaitValue()
            .assertHasValue()
            .assertValue { values -> values.size == 2}
    }


}