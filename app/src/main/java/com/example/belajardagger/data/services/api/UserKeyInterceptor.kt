package com.example.belajardagger.data.services.api

import okhttp3.Interceptor
import okhttp3.Response

class UserKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder().addHeader("user-key", "c859578f1f750b70d854def6427780d6").build()
        return chain.proceed(newRequest)
    }
}