package com.example.feature_games.di.modules

import com.example.feature_games.domain.usecase.GetGamesDetailUseCase
import com.example.feature_games.domain.usecase.GetGamesDetailUseCaseImpl
import com.example.igdb.di.scope.FeatureScope
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    @FeatureScope
    fun provideGamesDetailUseCase(useCaseImpl: GetGamesDetailUseCaseImpl): GetGamesDetailUseCase =
        useCaseImpl
}