package com.example.belajardagger.domain.usecase.games

import com.example.belajardagger.data.services.api.Resource
import com.example.belajardagger.data.model.Games

interface GetGamesDetailUseCase {
    suspend operator fun invoke(id: Int): Resource<Games>
}