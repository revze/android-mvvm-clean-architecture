package com.example.igdb.presentation.games.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.igdb.data.services.api.Resource
import com.example.igdb.domain.common.State
import com.example.igdb.domain.common.State.*
import com.example.igdb.data.model.Games
import com.example.igdb.domain.usecase.games.GetGamesUseCase
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
