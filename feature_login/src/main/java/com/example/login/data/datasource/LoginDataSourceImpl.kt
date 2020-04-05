package com.example.login.data.datasource

import com.example.login.data.response.LoginResponse
import kotlinx.coroutines.delay
import java.io.IOException
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor() : LoginDataSource {
    override suspend fun loginFacebook(fbId: String): LoginResponse {
        delay(800)
        return LoginResponse(200, "Revando", "revze@outlook.co.id", "1234567")
    }

    override suspend fun loginGoogle(googleId: String): LoginResponse {
        delay(800)
        return LoginResponse(200, "Revando", "dev.revze@gmail.com", "abcdefghijkl")
    }

    override suspend fun loginEmail(email: String, password: String): LoginResponse {
        delay(800)
        return LoginResponse(200, "Revando", email, "abcdefghijkl")
    }
}