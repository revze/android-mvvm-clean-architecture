package com.example.feature_games.di

import android.app.Application
import com.example.feature_games.di.modules.DataModule
import com.example.feature_games.di.modules.DomainModule
import com.example.feature_games.di.modules.ViewModelModule
import com.example.feature_games.presentation.GamesDetailActivity
import com.example.igdb.di.AppComponent
import com.example.igdb.di.modules.NetworkModule
import com.example.igdb.di.scope.FeatureScope
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@FeatureScope
@Component(modules = [DataModule::class, DomainModule::class, ViewModelModule::class], dependencies = [AppComponent::class])
interface GamesComponent {
    @Component.Builder
    interface Builder {
        fun appComponent(appComponent: AppComponent): Builder
        fun build(): GamesComponent
    }

    fun inject(activity: GamesDetailActivity)
}