package com.example.belajardagger.domain.usecase.games

import com.example.belajardagger.data.services.api.Resource
import com.example.belajardagger.data.model.Games

interface GetGamesUseCase {
    suspend operator fun invoke(): Resource<List<Games>>
//    operator fun invoke(scope: CoroutineScope): LiveData<State<List<Games>>>
}