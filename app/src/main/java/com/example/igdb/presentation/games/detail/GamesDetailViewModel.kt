package com.example.igdb.presentation.games.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.igdb.data.services.api.Resource
import com.example.igdb.domain.common.State
import com.example.igdb.domain.common.State.*
import com.example.igdb.data.model.Games
import com.example.igdb.domain.usecase.games.GetGamesDetailUseCase
import com.example.igdb.domain.usecase.others.GetGamesAndArticlesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class GamesDetailViewModel @Inject constructor(private val getGamesDetailUseCase: GetGamesDetailUseCase, private val useCase: GetGamesAndArticlesUseCase) :
    ViewModel() {
    val result = MutableLiveData<State<Games>>()

    fun getDetail(id: Int) {
        result.value = Loading()

        viewModelScope.launch(Dispatchers.IO) {
            when (val useCase = getGamesDetailUseCase(id)) {
                is Resource.Success -> {
                    result.postValue(Success(useCase.data))
                }
                is Resource.Error -> {
                    result.postValue(Error(useCase.message))
                }
            }
        }
    }

    fun getOthers() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = useCase()

            if (result is Resource.Success) {
                Timber.d(result.data.toString())
            } else if (result is Resource.Error) {
                Timber.d(result.message)
            }
        }
    }
}