package com.example.igdb.data.services.api

import android.app.Application
import com.example.igdb.R
import java.io.IOException

abstract class SubmitFormNetworkBoundResource<T>(private val application: Application) {
    suspend fun build(): Resource<T> {
        try {
            val result = networkCall()
            return Resource.Success(result)
        } catch (e: Exception) {
            if (e is IOException) {
                return Resource.Error(application.getString(R.string.no_internet_message), e)
            }
            return Resource.Error(application.getString(R.string.unknown_error_message), e)
        }
    }

    abstract suspend fun networkCall(): T
}