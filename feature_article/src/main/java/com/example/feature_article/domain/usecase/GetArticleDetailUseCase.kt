package com.example.feature_article.domain.usecase

import com.example.feature_article.data.repository.ArticleRepository
import com.example.igdb.data.model.Article
import com.example.igdb.data.services.api.Resource
import javax.inject.Inject

interface GetArticleDetailUseCase {
    suspend operator fun invoke(id: Int): Resource<Article>
}

class GetArticleDetailUseCaseImpl @Inject constructor(private val repository: ArticleRepository) :
    GetArticleDetailUseCase {
    override suspend fun invoke(id: Int): Resource<Article> {
        return repository.getArticleDetail(id)
    }
}