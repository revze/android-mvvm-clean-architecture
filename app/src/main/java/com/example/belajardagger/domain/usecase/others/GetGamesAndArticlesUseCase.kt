package com.example.belajardagger.domain.usecase.others

import com.example.belajardagger.data.services.api.Resource

interface GetGamesAndArticlesUseCase {
    suspend operator fun invoke(): Resource<HashMap<String, List<Any>>>
}