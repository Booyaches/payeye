package com.example.payeyetask.model

data class Employee(
    val name: String,
    val surname: String,
    val age: Int,
    val gender: Gender,
    val address: List<Address>
    )