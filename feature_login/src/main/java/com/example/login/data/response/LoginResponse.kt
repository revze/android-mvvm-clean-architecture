package com.example.login.data.response

data class LoginResponse (
    val statusCode: Int,
    val name: String,
    val email: String,
    val token: String
)