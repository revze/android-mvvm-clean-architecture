package com.example.feature_article.di.module

import com.example.feature_article.domain.usecase.GetArticleDetailUseCase
import com.example.feature_article.domain.usecase.GetArticleDetailUseCaseImpl
import com.example.igdb.di.scope.FeatureScope
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    @FeatureScope
    fun provideUseCase(useCaseImpl: GetArticleDetailUseCaseImpl): GetArticleDetailUseCase = useCaseImpl
}