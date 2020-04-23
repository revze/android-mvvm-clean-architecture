package com.example.login.data.repository

import android.app.Application
import com.example.igdb.data.services.api.Resource
import com.example.igdb.data.services.api.SubmitFormNetworkBoundResource
import com.example.login.data.datasource.LoginDataSource
import javax.inject.Inject

class LoginRespositoryImpl @Inject constructor(
    private val application: Application,
    private val dataSource: LoginDataSource
) : LoginRepository {
    override suspend fun loginFacebook(fbId: String): Resource<String> {
        return object : SubmitFormNetworkBoundResource<String>(application) {
            override suspend fun networkCall(): String {
                return dataSource.loginFacebook(fbId).token
            }
        }.build()
    }

    override suspend fun loginGoogle(googleId: String): Resource<String> {
        return object : SubmitFormNetworkBoundResource<String>(application) {
            override suspend fun networkCall(): String {
                return dataSource.loginGoogle(googleId).token
            }
        }.build()
    }

    override suspend fun loginEmail(email: String, password: String): Resource<String> {
        return object : SubmitFormNetworkBoundResource<String>(application) {
            override suspend fun networkCall(): String {
                return dataSource.loginEmail(email, password).token
            }
        }.build()
    }
}