package com.example.igdb.domain.usecase.games

import com.example.igdb.data.services.api.Resource
import com.example.igdb.data.model.Games

interface GetGamesDetailUseCase {
    suspend operator fun invoke(id: Int): Resource<Games>
}