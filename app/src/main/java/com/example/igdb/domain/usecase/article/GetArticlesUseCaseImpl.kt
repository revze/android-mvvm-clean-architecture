package com.example.igdb.domain.usecase.article

import com.example.igdb.data.services.api.Resource
import com.example.igdb.data.model.Article
import com.example.igdb.data.repository.IgdbRepository
import javax.inject.Inject

class GetArticlesUseCaseImpl @Inject constructor(private val repository: IgdbRepository) : GetArticlesUseCase {
    override suspend fun invoke(): Resource<List<Article>> {
        return repository.getArticles()
    }
}