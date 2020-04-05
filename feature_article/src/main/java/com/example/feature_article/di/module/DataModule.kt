package com.example.feature_article.di.module

import com.example.feature_article.data.repository.ArticleRepository
import com.example.feature_article.data.repository.ArticleRepositoryImpl
import com.example.igdb.di.scope.FeatureScope
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    @FeatureScope
    fun provideRepository(repositoryImpl: ArticleRepositoryImpl): ArticleRepository = repositoryImpl
}