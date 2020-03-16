package com.example.igdb.di.builder

import com.example.igdb.presentation.article.list.ArticlesFragment
import com.example.igdb.presentation.games.list.GamesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilder {
    @ContributesAndroidInjector
    abstract fun bindGamesFragment(): GamesFragment

    @ContributesAndroidInjector
    abstract fun bindArticlesFragment(): ArticlesFragment
}