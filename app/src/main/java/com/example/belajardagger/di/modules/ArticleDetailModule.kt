package com.example.belajardagger.di.modules

import com.example.belajardagger.presentation.base.BaseViewModelFactory
import com.example.belajardagger.presentation.article.detail.ArticleDetailViewModel
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