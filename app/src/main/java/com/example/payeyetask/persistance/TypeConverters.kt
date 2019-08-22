package com.example.payeyetask.persistance

import androidx.room.TypeConverter
import com.example.payeyetask.model.Gender

class TypeConverters {

    @TypeConverter
    fun fromIntToGender(value: Int) = when(value) {
        1 -> Gender.MALE
        2 -> Gender.FEMALE
        else -> Gender.UNSPECIFIED
    }

    @TypeConverter
    fun fromGenderToInt(value: Gender) = when(value) {
        Gender.MALE -> 1
        Gender.FEMALE -> 2
        else -> 0
    }
}