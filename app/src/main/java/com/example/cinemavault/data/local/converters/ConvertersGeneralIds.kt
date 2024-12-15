package com.example.cinemavault.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ConvertersGeneralIds {
    @TypeConverter
    fun fromListToString(value: List<Int>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromStringToList(value: String): List<Int> {
        val dataType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(value, dataType)
    }
}