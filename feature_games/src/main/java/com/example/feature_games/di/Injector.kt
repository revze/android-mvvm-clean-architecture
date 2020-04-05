package com.example.feature_games.di

import android.app.Activity
import com.example.igdb.AndroidApplication

object Injector {
    fun create( activity: Activity): GamesComponent {
        val application = activity.application as AndroidApplication
        return DaggerGamesComponent.builder().appComponent(application.getInjector()).build()
    }
}