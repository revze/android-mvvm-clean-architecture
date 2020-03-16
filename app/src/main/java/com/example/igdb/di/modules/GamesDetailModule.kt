package com.example.igdb.di.modules

import com.example.igdb.presentation.base.BaseViewModelFactory
import com.example.igdb.external.helper.DialogHelper
import com.example.igdb.presentation.games.detail.GamesDetailActivity
import com.example.igdb.presentation.games.detail.GamesDetailViewModel
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