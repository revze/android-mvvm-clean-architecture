package com.example.feature_article.di.module

import com.example.feature_article.presentation.ArticleDetailViewModel
import com.example.igdb.di.scope.FeatureScope
import com.example.igdb.presentation.base.BaseViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    @FeatureScope
    fun provideViewModelFactory(viewModel: ArticleDetailViewModel) = BaseViewModelFactory { viewModel }
}