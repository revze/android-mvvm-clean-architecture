package com.example.login.domain.usecase

import com.example.igdb.data.services.api.Resource
import com.example.login.data.repository.LoginRepository
import javax.inject.Inject

interface LoginFacebookUseCase {
    suspend operator fun invoke(id: String): Resource<String>
}

class LoginFacebookUseCaseImpl @Inject constructor(private val repository: LoginRepository): LoginFacebookUseCase {
    override suspend fun invoke(id: String) = repository.loginFacebook(id)
}