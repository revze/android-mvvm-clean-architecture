package com.example.login.presentation.loginemail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.igdb.data.services.api.Resource
import com.example.igdb.presentation.base.BaseViewModel
import com.example.login.domain.usecase.LoginEmailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginEmailViewModel @Inject constructor(
    private val loginEmailUseCase: LoginEmailUseCase
) : BaseViewModel() {
    val resultLiveData = MutableLiveData<String>()

    fun loginEmail(email: String, password: String) = viewModelScope.launch(Dispatchers.IO) {
        withContext(Dispatchers.Main) { loadingLiveData.value = true }
        when (val result = loginEmailUseCase(email, password)) {
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