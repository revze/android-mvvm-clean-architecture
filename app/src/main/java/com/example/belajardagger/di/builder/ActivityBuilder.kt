package com.example.belajardagger.di.builder

import com.example.belajardagger.di.modules.ArticleDetailModule
import com.example.belajardagger.di.modules.GamesDetailModule
import com.example.belajardagger.di.modules.MainModule
import com.example.belajardagger.di.scope.ActivityScope
import com.example.belajardagger.presentation.article.detail.ArticleDetailActivity
import com.example.belajardagger.presentation.games.detail.GamesDetailActivity
import com.example.belajardagger.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, MainFragmentBuilder::class])
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [GamesDetailModule::class])
    abstract fun bindGamesDetailActivity(): GamesDetailActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ArticleDetailModule::class])
    abstract fun bindArticleDetailActivity(): ArticleDetailActivity
}