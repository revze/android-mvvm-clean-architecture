package com.example.igdb.data.services.api

import android.app.Application
import com.example.igdb.R
import java.io.IOException

abstract class NetworkBoundResource<T>(private val application: Application) {
    suspend fun build(): Resource<T> {
        try {
            val result = networkCall()
            if (isOfflineFirstEnabled()) insertToCache(result)
            return Resource.Success(result)
        } catch (e: Exception) {
            if (e is IOException) {
                if (isOfflineFirstEnabled()) {
                    val result = loadFromCache()

                    if (result != null) {
                        return Resource.Success(result)
                    }

                    return Resource.Error(
                        application.getString(R.string.no_internet_message),
                        e
                    )
                }
                return Resource.Error(application.getString(R.string.no_internet_message), e)
            }
            return Resource.Error(application.getString(R.string.unknown_error_message), e)
        }
    }

    abstract suspend fun networkCall(): T

    abstract fun isOfflineFirstEnabled(): Boolean

    abstract suspend fun loadFromCache(): T?

    abstract suspend fun insertToCache(data: T)
}