package com.example.belajardagger.presentation.games.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.belajardagger.data.services.api.Resource
import com.example.belajardagger.domain.common.State
import com.example.belajardagger.domain.common.State.*
import com.example.belajardagger.data.model.Games
import com.example.belajardagger.domain.usecase.games.GetGamesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GamesViewModel @Inject constructor(private val getGamesUseCase: GetGamesUseCase) :
    ViewModel() {
    val result = MutableLiveData<State<List<Games>>>()

    fun getGames() {
        result.value = Loading()

        viewModelScope.launch(Dispatchers.IO) {
            when (val useCase = getGamesUseCase()) {
                is Resource.Success -> {
                    result.postValue(Success(useCase.data))
                }
                is Resource.Error -> {
                    result.postValue(Error(useCase.message))
                }
            }
        }
    }
}
