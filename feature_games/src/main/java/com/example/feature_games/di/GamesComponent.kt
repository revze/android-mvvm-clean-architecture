package com.example.feature_games.di

import android.app.Activity
import com.example.feature_games.di.modules.DataModule
import com.example.feature_games.di.modules.DomainModule
import com.example.feature_games.di.modules.ViewModelModule
import com.example.feature_games.presentation.gamesdetail.GamesDetailActivity
import com.example.feature_games.presentation.gameslist.GamesListFragment
import com.example.igdb.di.AppComponent
import com.example.igdb.di.scope.FeatureScope
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    modules = [DataModule::class, DomainModule::class, ViewModelModule::class],
    dependencies = [AppComponent::class]
)
interface GamesComponent {
    @Component.Builder
    interface Builder {
        fun initAppComponent(appComponent: AppComponent): Builder
        fun initActivity(@BindsInstance activity: Activity): Builder
        fun build(): GamesComponent
    }

    fun inject(activity: GamesDetailActivity)

    fun inject(fragment: GamesListFragment)
}