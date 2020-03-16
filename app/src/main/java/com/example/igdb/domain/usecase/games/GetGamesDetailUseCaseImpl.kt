package com.example.igdb.domain.usecase.games

import com.example.igdb.data.services.api.Resource
import com.example.igdb.data.model.Games
import com.example.igdb.data.repository.IgdbRepository
import javax.inject.Inject

class GetGamesDetailUseCaseImpl @Inject constructor(private val repository: IgdbRepository) : GetGamesDetailUseCase {
    override suspend fun invoke(id: Int): Resource<Games> {
        return repository.getGames(id)
    }
}