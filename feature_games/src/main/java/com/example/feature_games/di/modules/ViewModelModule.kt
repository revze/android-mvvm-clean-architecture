package com.example.feature_games.di.modules

import com.example.feature_games.presentation.gamesdetail.GamesDetailViewModel
import com.example.feature_games.presentation.gameslist.GamesListViewModel
import com.example.igdb.di.scope.FeatureScope
import com.example.igdb.presentation.base.BaseViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    @FeatureScope
    fun provideGamesDetailViewModelFactory(viewModel: GamesDetailViewModel): BaseViewModelFactory<GamesDetailViewModel> {
        return BaseViewModelFactory {
            viewModel
        }
    }

    @Provides
    @FeatureScope
    fun provideGamesListViewModelFactory(viewModel: GamesListViewModel): BaseViewModelFactory<GamesListViewModel> {
        return BaseViewModelFactory {
            viewModel
        }
    }
}