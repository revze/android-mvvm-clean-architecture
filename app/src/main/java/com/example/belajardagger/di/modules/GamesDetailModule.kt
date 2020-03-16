package com.example.belajardagger.di.modules

import com.example.belajardagger.presentation.base.BaseViewModelFactory
import com.example.belajardagger.external.helper.DialogHelper
import com.example.belajardagger.presentation.games.detail.GamesDetailActivity
import com.example.belajardagger.presentation.games.detail.GamesDetailViewModel
import dagger.Module
import dagger.Provides

@Module
class GamesDetailModule {
    @Provides
    fun provideViewModelFactory(viewModel: GamesDetailViewModel): BaseViewModelFactory<GamesDetailViewModel> {
        return BaseViewModelFactory {
            viewModel
        }
    }

    @Provides
    fun provideDialogHelper(activity: GamesDetailActivity): DialogHelper {
        return DialogHelper(activity)
    }
}