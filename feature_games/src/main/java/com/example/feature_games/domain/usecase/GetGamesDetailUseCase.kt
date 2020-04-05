package com.example.feature_games.domain.usecase

import com.example.feature_games.data.repository.GamesRepository
import com.example.igdb.data.model.Games
import com.example.igdb.data.services.api.Resource
import javax.inject.Inject

interface GetGamesDetailUseCase {
    suspend operator fun invoke(id: Int): Resource<Games>
}

class GetGamesDetailUseCaseImpl @Inject constructor(private val repository: GamesRepository): GetGamesDetailUseCase {
    override suspend fun invoke(id: Int): Resource<Games> {
        return repository.getGamesDetail(id)
    }
}