package com.example.payeyetask.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class Employee(
    val name: String,
    val surname: String,
    val age: Int,
    val gender: Gender) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}