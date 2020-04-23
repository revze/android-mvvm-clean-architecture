package com.example.feature_games.domain.usecase

import com.example.feature_games.data.repository.GamesRepository
import com.example.igdb.data.model.Games
import com.example.igdb.data.services.api.Resource
import javax.inject.Inject

interface GetGamesListUseCase {
    suspend operator fun invoke(): Resource<List<Games>>
}

class GetGamesListUseCaseImpl @Inject constructor(private val repository: GamesRepository) :
    GetGamesListUseCase {
    override suspend fun invoke(): Resource<List<Games>> {
        return repository.getGames()
    }
}