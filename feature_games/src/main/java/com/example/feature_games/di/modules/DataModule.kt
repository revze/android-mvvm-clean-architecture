package com.example.feature_games.di.modules

import com.example.feature_games.data.repository.GamesRepository
import com.example.feature_games.data.repository.GamesRepositoryImpl
import com.example.igdb.di.scope.FeatureScope
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    @FeatureScope
    fun provideGamesRepository(repositoryImpl: GamesRepositoryImpl): GamesRepository =
        repositoryImpl
}