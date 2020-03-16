package com.example.belajardagger.domain.usecase.games

import com.example.belajardagger.data.services.api.Resource
import com.example.belajardagger.data.model.Games
import com.example.belajardagger.data.repository.IgdbRepository
import javax.inject.Inject

class GetGamesDetailUseCaseImpl @Inject constructor(private val repository: IgdbRepository) : GetGamesDetailUseCase {
    override suspend fun invoke(id: Int): Resource<Games> {
        return repository.getGames(id)
    }
}