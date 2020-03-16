package com.example.igdb.di.modules

import com.example.igdb.data.repository.IgdbRepository
import com.example.igdb.data.repository.IgdbRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideGamesRepository(repositoryImpl: IgdbRepositoryImpl): IgdbRepository =
        repositoryImpl
}