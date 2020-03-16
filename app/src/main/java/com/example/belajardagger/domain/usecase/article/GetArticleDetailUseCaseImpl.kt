package com.example.belajardagger.domain.usecase.article

import com.example.belajardagger.data.repository.IgdbRepository
import javax.inject.Inject

class GetArticleDetailUseCaseImpl @Inject constructor(private val repository: IgdbRepository) :
    GetArticleDetailUseCase {
    override suspend fun invoke(id: Int) = repository.getArticle(id)
}