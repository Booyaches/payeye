package com.example.payeyetask.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "address",
    foreignKeys = [ForeignKey(
        entity = Employee::class,
        parentColumns = ["id"],
        childColumns = ["employeeId"],
        onDelete = CASCADE
    )]
)
data class Address(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val street: String,
    val building: String,
    val apartmentNo: Int,
    val city: String,
    val zipCode: String,
    val employeeId: Long
)