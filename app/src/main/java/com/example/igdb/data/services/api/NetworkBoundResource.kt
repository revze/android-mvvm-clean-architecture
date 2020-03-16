package com.example.igdb.data.services.api

import android.app.Application
import com.example.igdb.R
import java.io.IOException

abstract class NetworkBoundResource<T>(private val application: Application) {
    suspend fun build(): Resource<T> {
        try {
            val result = networkCall()
            if (shouldLoadFromCache()) insertToCache(result)
            return Resource.Success(result)
        } catch (e: Exception) {
            if (e is IOException) {
                if (shouldLoadFromCache()) {
                    val result = loadFromCache()

                    if (result is List<*>) {
                        return if (result.isNotEmpty()) {
                            Resource.Success(result)
                        } else {
                            Resource.Error(
                                application.getString(R.string.no_internet_message),
                                e
                            )
                        }
                    }

                    return Resource.Success(result)
                }
                return Resource.Error(application.getString(R.string.no_internet_message), e)
            }
            return Resource.Error(application.getString(R.string.unknown_error_message), e)
        }
    }

    abstract suspend fun networkCall(): T

    abstract fun shouldLoadFromCache(): Boolean

    abstract suspend fun loadFromCache(): T

    abstract suspend fun insertToCache(data: T)
}