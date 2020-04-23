package com.example.feature_games.presentation.gamesdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feature_games.domain.usecase.GetGamesDetailUseCase
import com.example.igdb.data.model.Games
import com.example.igdb.data.services.api.Resource
import com.example.igdb.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GamesDetailViewModel @Inject constructor(private val useCase: GetGamesDetailUseCase) : BaseViewModel() {
    val detailLiveData = MutableLiveData<Games>()

    fun getGamesDetail(id: Int) {
        loadingLiveData.value = true
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = useCase(id)) {
                is Resource.Success -> {
                    loadingLiveData.postValue(false)
                    detailLiveData.postValue(result.data)
                }
                is Resource.Error -> {
                    loadingLiveData.postValue(false)
                    errorLiveData.postValue(result.message)
                }
            }
        }
    }
}