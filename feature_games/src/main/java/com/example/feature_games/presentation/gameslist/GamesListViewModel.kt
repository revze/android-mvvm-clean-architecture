package com.example.feature_games.presentation.gameslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_games.domain.usecase.GetGamesListUseCase
import com.example.igdb.data.model.Games
import com.example.igdb.data.services.api.Resource
import com.example.igdb.domain.common.State
import com.example.igdb.domain.common.State.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GamesListViewModel @Inject constructor(private val getGamesListUseCase: GetGamesListUseCase) :
    ViewModel() {
    val result = MutableLiveData<State<List<Games>>>()

    fun getGames() {
        result.value = Loading()

        viewModelScope.launch(Dispatchers.IO) {
            when (val useCase = getGamesListUseCase()) {
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
