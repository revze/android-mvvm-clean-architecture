package com.example.igdb.domain.usecase.article

import com.example.igdb.data.services.api.Resource
import com.example.igdb.data.model.Article

interface GetArticlesUseCase {
    suspend operator fun invoke(): Resource<List<Article>>
}