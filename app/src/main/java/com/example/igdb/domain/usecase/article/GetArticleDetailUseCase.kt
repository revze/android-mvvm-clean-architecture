package com.example.igdb.domain.usecase.article

import com.example.igdb.data.services.api.Resource
import com.example.igdb.data.model.Article

interface GetArticleDetailUseCase {
    suspend operator fun invoke(id: Int): Resource<Article>
}