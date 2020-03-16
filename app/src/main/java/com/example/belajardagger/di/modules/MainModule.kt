package com.example.belajardagger.di.modules

import com.example.belajardagger.presentation.base.BaseViewModelFactory
import com.example.belajardagger.external.helper.DialogHelper
import com.example.belajardagger.presentation.article.list.ArticlesViewModel
import com.example.belajardagger.presentation.games.list.GamesViewModel
import com.example.belajardagger.presentation.main.MainActivity
import com.example.belajardagger.presentation.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun provideDialogHelper(activity: MainActivity): DialogHelper {
        return DialogHelper(activity)
    }

    @Provides
    fun provideGamesViewModelFactory(viewModel: GamesViewModel): BaseViewModelFactory<GamesViewModel> {
        return BaseViewModelFactory { viewModel }
    }

    @Provides
    fun provideArticlesViewModelFactory(viewModel: ArticlesViewModel): BaseViewModelFactory<ArticlesViewModel> {
        return BaseViewModelFactory { viewModel }
    }

    @Provides
    fun provideMainViewModelFactory(viewModel: MainViewModel): BaseViewModelFactory<MainViewModel> {
        return BaseViewModelFactory { viewModel }
    }
}