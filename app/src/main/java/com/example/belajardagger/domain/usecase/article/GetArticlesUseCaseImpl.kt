package com.example.belajardagger.domain.usecase.article

import com.example.belajardagger.data.services.api.Resource
import com.example.belajardagger.data.model.Article
import com.example.belajardagger.data.repository.IgdbRepository
import javax.inject.Inject

class GetArticlesUseCaseImpl @Inject constructor(private val repository: IgdbRepository) : GetArticlesUseCase {
    override suspend fun invoke(): Resource<List<Article>> {
        return repository.getArticles()
    }
}