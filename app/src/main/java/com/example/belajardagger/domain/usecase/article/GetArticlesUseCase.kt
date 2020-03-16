package com.example.belajardagger.domain.usecase.article

import com.example.belajardagger.data.services.api.Resource
import com.example.belajardagger.data.model.Article

interface GetArticlesUseCase {
    suspend operator fun invoke(): Resource<List<Article>>
}