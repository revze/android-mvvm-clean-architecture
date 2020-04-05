package com.example.igdb.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val loadingLiveData = MutableLiveData<Boolean>()
    val errorLiveData = MutableLiveData<String>()
}