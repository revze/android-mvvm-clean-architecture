package com.example.login.di.modules

import com.example.igdb.di.scope.FeatureScope
import com.example.login.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    @FeatureScope
    fun provideLoginFacebookUseCase(useCaseImpl: LoginFacebookUseCaseImpl): LoginFacebookUseCase =
        useCaseImpl

    @Provides
    @FeatureScope
    fun provideLoginGoogleUseCase(useCaseImpl: LoginGoogleUseCaseImpl): LoginGoogleUseCase =
        useCaseImpl

    @Provides
    @FeatureScope
    fun provideLoginEmailUseCase(useCaseImpl: LoginEmailUseCaseImpl): LoginEmailUseCase =
        useCaseImpl

}