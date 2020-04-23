package com.example.feature_article.di.module

import com.example.feature_article.presentation.articledetail.ArticleDetailViewModel
import com.example.feature_article.presentation.articlelist.ArticleListViewModel
import com.example.igdb.di.scope.FeatureScope
import com.example.igdb.presentation.base.BaseViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    @FeatureScope
    fun provideArticleDetailViewModelFactory(viewModel: ArticleDetailViewModel) =
        BaseViewModelFactory { viewModel }

    @Provides
    @FeatureScope
    fun provideArticleListViewModel(viewModel: ArticleListViewModel) =
        BaseViewModelFactory { viewModel }
}