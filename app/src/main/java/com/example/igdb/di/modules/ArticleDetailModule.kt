package com.example.igdb.di.modules

import com.example.igdb.presentation.base.BaseViewModelFactory
import com.example.igdb.presentation.article.detail.ArticleDetailViewModel
import dagger.Module
import dagger.Provides

@Module
class ArticleDetailModule {
    @Provides
    fun provideViewModelFactory(viewModel: ArticleDetailViewModel): BaseViewModelFactory<ArticleDetailViewModel> =
        BaseViewModelFactory {
            viewModel
        }
}