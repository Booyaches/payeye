package com.example.payeyetask.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.payeyetask.model.Address

@Dao
interface AddressDAO {

    @Insert
    suspend fun addAddress(address: Address)

    @Query("SELECT * FROM address WHERE employeeId = :employeeId")
    suspend fun getEmployeesAddresses(employeeId: Long): List<Address>?
}