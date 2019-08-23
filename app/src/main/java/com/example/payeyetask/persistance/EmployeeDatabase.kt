package com.example.payeyetask.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.payeyetask.model.Address
import com.example.payeyetask.model.Employee
import com.example.payeyetask.persistance.dao.AddressDAO
import com.example.payeyetask.persistance.dao.EmployeeDAO

@Database(entities = [Employee::class, Address::class], version = 1)
@TypeConverters(com.example.payeyetask.persistance.TypeConverters::class)

abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDAO
    abstract fun addressDao(): AddressDAO

    companion object {

        @Volatile
        private var INSTANCE: EmployeeDatabase? = null
        private const val DATABASE_NAME = "employee_database"

        fun getDatabase(context: Context): EmployeeDatabase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null)
                return tmpInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EmployeeDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}