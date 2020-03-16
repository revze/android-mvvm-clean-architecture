package com.example.igdb.domain.usecase.others

import com.example.igdb.data.services.api.Resource

interface GetGamesAndArticlesUseCase {
    suspend operator fun invoke(): Resource<HashMap<String, List<Any>>>
}