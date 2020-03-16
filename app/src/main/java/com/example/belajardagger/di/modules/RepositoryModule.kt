package com.example.belajardagger.di.modules

import com.example.belajardagger.data.repository.IgdbRepository
import com.example.belajardagger.data.repository.IgdbRepositoryImpl
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