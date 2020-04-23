package com.example.feature_article.domain.usecase

import com.example.feature_article.data.repository.ArticleRepository
import com.example.igdb.data.model.Article
import com.example.igdb.data.services.api.Resource
import javax.inject.Inject

interface GetArticleListUseCase {
    suspend operator fun invoke(): Resource<List<Article>>
}

class GetArticleListUseCaseImpl @Inject constructor(private val repository: ArticleRepository) :
    GetArticleListUseCase {
    override suspend fun invoke(): Resource<List<Article>> {
        return repository.getArticles()
    }
}