package com.example.belajardagger.domain.usecase.article

import com.example.belajardagger.data.services.api.Resource
import com.example.belajardagger.data.model.Article

interface GetArticleDetailUseCase {
    suspend operator fun invoke(id: Int): Resource<Article>
}