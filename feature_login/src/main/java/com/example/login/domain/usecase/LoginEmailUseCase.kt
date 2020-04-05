package com.example.login.domain.usecase

import com.example.igdb.data.services.api.Resource
import com.example.login.data.repository.LoginRepository
import javax.inject.Inject

interface LoginEmailUseCase {
    suspend operator fun invoke(email: String, password: String): Resource<String>
}

class LoginEmailUseCaseImpl @Inject constructor(private val repository: LoginRepository): LoginEmailUseCase {
    override suspend fun invoke(email: String, password: String): Resource<String> {
        return repository.loginEmail(email, password)
    }
}