package com.example.login.data.repository

import com.example.igdb.data.services.api.Resource

interface LoginRepository {
    suspend fun loginFacebook(fbId: String): Resource<String>

    suspend fun loginGoogle(googleId: String): Resource<String>

    suspend fun loginEmail(email: String, password: String): Resource<String>
}