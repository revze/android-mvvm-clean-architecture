package com.example.login.di.modules

import com.example.igdb.di.scope.FeatureScope
import com.example.igdb.presentation.base.BaseViewModelFactory
import com.example.login.presentation.login.LoginViewModel
import com.example.login.presentation.loginemail.LoginEmailViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    @FeatureScope
    fun provideLoginViewModel(viewModel: LoginViewModel): BaseViewModelFactory<LoginViewModel> =
        BaseViewModelFactory { viewModel }

    @Provides
    @FeatureScope
    fun provideLogin2ViewModel(viewModel: LoginEmailViewModel): BaseViewModelFactory<LoginEmailViewModel> =
        BaseViewModelFactory { viewModel }

}