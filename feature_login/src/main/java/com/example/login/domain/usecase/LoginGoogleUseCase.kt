package com.example.login.domain.usecase

import com.example.igdb.data.services.api.Resource
import com.example.login.data.repository.LoginRepository
import javax.inject.Inject

interface LoginGoogleUseCase {
    suspend operator fun invoke(id: String): Resource<String>
}

class LoginGoogleUseCaseImpl @Inject constructor(private val repository: LoginRepository): LoginGoogleUseCase {
    override suspend fun invoke(id: String) = repository.loginGoogle(id)
}