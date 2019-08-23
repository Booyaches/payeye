package com.example.payeyetask.ui.editor

import com.example.payeyetask.persistance.EmployeeDatabase
import com.example.payeyetask.ui.base.BaseRepository

class EditorActivityRepository(database: EmployeeDatabase) : BaseRepository(database){
    private val employeeDao = database.employeeDao()



}