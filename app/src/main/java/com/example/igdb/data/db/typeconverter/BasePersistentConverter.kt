package com.example.igdb.data.db.typeconverter

import com.squareup.moshi.Moshi
import java.lang.reflect.ParameterizedType

class BasePersistentConverter<T>(private val type: ParameterizedType) {
    fun convertToString(data: List<T>?): String {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter<List<T>>(type)
        return adapter.toJson(data)
    }

    fun convertToObject(data: String): List<T>? {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter<List<T>>(type)
        return adapter.fromJson(data)
    }
}