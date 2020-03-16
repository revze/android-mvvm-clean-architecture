package com.example.belajardagger.di.builder

import com.example.belajardagger.presentation.article.list.ArticlesFragment
import com.example.belajardagger.presentation.games.list.GamesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilder {
    @ContributesAndroidInjector
    abstract fun bindGamesFragment(): GamesFragment

    @ContributesAndroidInjector
    abstract fun bindArticlesFragment(): ArticlesFragment
}