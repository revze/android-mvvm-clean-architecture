package com.example.belajardagger.domain.usecase.others

import com.example.belajardagger.data.services.api.Resource
import com.example.belajardagger.domain.usecase.article.GetArticlesUseCase
import com.example.belajardagger.domain.usecase.games.GetGamesUseCase
import javax.inject.Inject

class GetGamesAndArticlesUseCaseImpl @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase,
    private val getArticlesUseCase: GetArticlesUseCase
) : GetGamesAndArticlesUseCase {
    override suspend fun invoke(): Resource<HashMap<String, List<Any>>> {
        val articles = getGamesUseCase()
        val games = getArticlesUseCase()
        val map = HashMap<String, List<Any>>()

        return if (articles is Resource.Success && games is Resource.Success) {
            map["games"] = games.data
            map["articles"] = articles.data

            Resource.Success(map)
        } else if (articles is Resource.Error) {
            Resource.Error(articles.message)
        } else {
            games as Resource.Error
            Resource.Error(games.message)
        }
    }
}