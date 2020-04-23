package com.example.feature_article.di.module

import com.example.feature_article.domain.usecase.GetArticleDetailUseCase
import com.example.feature_article.domain.usecase.GetArticleDetailUseCaseImpl
import com.example.feature_article.domain.usecase.GetArticleListUseCase
import com.example.feature_article.domain.usecase.GetArticleListUseCaseImpl
import com.example.igdb.di.scope.FeatureScope
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    @FeatureScope
    fun provideGetArticleDetailUseCase(useCaseImpl: GetArticleDetailUseCaseImpl): GetArticleDetailUseCase =
        useCaseImpl

    @Provides
    @FeatureScope
    fun provideGetArticleListUseCase(useCaseImpl: GetArticleListUseCaseImpl): GetArticleListUseCase =
        useCaseImpl
}