package com.example.login.data.repository

import android.app.Application
import com.example.igdb.data.services.api.NetworkBoundResource
import com.example.igdb.data.services.api.Resource
import com.example.login.data.datasource.LoginDataSource
import javax.inject.Inject

class LoginRespositoryImpl @Inject constructor(private val application: Application, private val dataSource: LoginDataSource) : LoginRepository {
    override suspend fun loginFacebook(fbId: String): Resource<String> {
        return object : NetworkBoundResource<String>(application) {
            override suspend fun networkCall(): String {
                return dataSource.loginFacebook(fbId).token
            }

            override fun isOfflineFirstEnabled() = false

            override suspend fun loadFromCache(): String? {
                TODO("Not yet implemented")
            }

            override suspend fun insertToCache(data: String) {
                TODO("Not yet implemented")
            }

        }.build()
    }

    override suspend fun loginGoogle(googleId: String): Resource<String> {
        return object : NetworkBoundResource<String>(application) {
            override suspend fun networkCall(): String {
                return dataSource.loginGoogle(googleId).token
            }

            override fun isOfflineFirstEnabled() = false

            override suspend fun loadFromCache(): String? {
                TODO("Not yet implemented")
            }

            override suspend fun insertToCache(data: String) {
                TODO("Not yet implemented")
            }

        }.build()
    }

    override suspend fun loginEmail(email: String, password: String): Resource<String> {
        return object : NetworkBoundResource<String>(application) {
            override suspend fun networkCall(): String {
                return dataSource.loginEmail(email, password).token
            }

            override fun isOfflineFirstEnabled() = false

            override suspend fun loadFromCache(): String? {
                TODO("Not yet implemented")
            }

            override suspend fun insertToCache(data: String) {
                TODO("Not yet implemented")
            }

        }.build()
    }
}