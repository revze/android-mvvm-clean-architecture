package com.example.login.data.datasource

import com.example.login.data.response.LoginResponse

interface LoginDataSource {
    suspend fun loginFacebook(fbId: String): LoginResponse

    suspend fun loginGoogle(googleId: String): LoginResponse

    suspend fun loginEmail(email: String, password: String): LoginResponse
}