package com.example.belajardagger.di.modules

import com.example.belajardagger.domain.usecase.article.GetArticleDetailUseCase
import com.example.belajardagger.domain.usecase.article.GetArticleDetailUseCaseImpl
import com.example.belajardagger.domain.usecase.article.GetArticlesUseCase
import com.example.belajardagger.domain.usecase.article.GetArticlesUseCaseImpl
import com.example.belajardagger.domain.usecase.games.GetGamesDetailUseCase
import com.example.belajardagger.domain.usecase.games.GetGamesDetailUseCaseImpl
import com.example.belajardagger.domain.usecase.games.GetGamesUseCase
import com.example.belajardagger.domain.usecase.games.GetGamesUseCaseImpl
import com.example.belajardagger.domain.usecase.others.GetGamesAndArticlesUseCase
import com.example.belajardagger.domain.usecase.others.GetGamesAndArticlesUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetGamesUseCase(useCaseImpl: GetGamesUseCaseImpl): GetGamesUseCase = useCaseImpl

    @Singleton
    @Provides
    fun provideGetGamesDetailUseCase(useCaseImpl: GetGamesDetailUseCaseImpl): GetGamesDetailUseCase =
        useCaseImpl

    @Singleton
    @Provides
    fun provideGetArticlesUseCase(useCaseImpl: GetArticlesUseCaseImpl): GetArticlesUseCase =
        useCaseImpl

    @Singleton
    @Provides
    fun provideGetGamesAndArticleUseCase(useCaseImpl: GetGamesAndArticlesUseCaseImpl): GetGamesAndArticlesUseCase =
        useCaseImpl

    @Singleton
    @Provides
    fun provideGetArticleDetailUseCase(useCaseImpl: GetArticleDetailUseCaseImpl): GetArticleDetailUseCase =
        useCaseImpl
}