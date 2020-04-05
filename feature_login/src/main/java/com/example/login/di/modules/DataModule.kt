package com.example.login.di.modules

import com.example.igdb.di.scope.FeatureScope
import com.example.login.data.datasource.LoginDataSource
import com.example.login.data.datasource.LoginDataSourceImpl
import com.example.login.data.repository.LoginRepository
import com.example.login.data.repository.LoginRespositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    @FeatureScope
    fun providDataSource(dataSource: LoginDataSourceImpl): LoginDataSource = dataSource

    @Provides
    @FeatureScope
    fun provideRepository(repository: LoginRespositoryImpl): LoginRepository = repository
}