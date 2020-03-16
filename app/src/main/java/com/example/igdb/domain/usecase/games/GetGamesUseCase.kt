package com.example.igdb.domain.usecase.games

import com.example.igdb.data.services.api.Resource
import com.example.igdb.data.model.Games

interface GetGamesUseCase {
    suspend operator fun invoke(): Resource<List<Games>>
//    operator fun invoke(scope: CoroutineScope): LiveData<State<List<Games>>>
}