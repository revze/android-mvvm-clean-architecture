package com.example.login.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.igdb.data.services.api.Resource
import com.example.igdb.presentation.base.BaseViewModel
import com.example.login.domain.usecase.LoginFacebookUseCase
import com.example.login.domain.usecase.LoginGoogleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginFacebookUseCase: LoginFacebookUseCase,
    private val loginGoogleUseCase: LoginGoogleUseCase
) : BaseViewModel() {
    val resultLiveData = MutableLiveData<String>()

    fun loginFacebook(id: String) = viewModelScope.launch(Dispatchers.IO) {
        withContext(Dispatchers.Main) { loadingLiveData.value = true }
        when (val result = loginFacebookUseCase(id)) {
            is Resource.Success -> {
                withContext(Dispatchers.Main) { loadingLiveData.value = false }
                resultLiveData.postValue(result.data)
            }
            is Resource.Error -> {
                withContext(Dispatchers.Main) { loadingLiveData.value = false }
                errorLiveData.postValue(result.message)
            }
        }
    }

    fun loginGoogle(id: String) = viewModelScope.launch(Dispatchers.IO) {
        withContext(Dispatchers.Main) { loadingLiveData.value = true }
        when (val result = loginGoogleUseCase(id)) {
            is Resource.Success -> {
                withContext(Dispatchers.Main) { loadingLiveData.value = false }
                resultLiveData.postValue(result.data)
            }
            is Resource.Error -> {
                withContext(Dispatchers.Main) { loadingLiveData.value = false }
                errorLiveData.postValue(result.message)
            }
        }
    }
}