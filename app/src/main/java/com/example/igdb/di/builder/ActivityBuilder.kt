package com.example.igdb.di.builder

import com.example.igdb.di.modules.ArticleDetailModule
import com.example.igdb.di.modules.GamesDetailModule
import com.example.igdb.di.modules.MainModule
import com.example.igdb.di.scope.ActivityScope
import com.example.igdb.presentation.article.detail.ArticleDetailActivity
import com.example.igdb.presentation.games.detail.GamesDetailActivity
import com.example.igdb.presentation.main.MainActivity
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