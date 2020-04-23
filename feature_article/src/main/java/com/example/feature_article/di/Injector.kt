package com.example.feature_article.di

import android.app.Activity
import com.example.igdb.AndroidApplication

object Injector {
    fun create(activity: Activity): ArticleComponent {
        val app = activity.application as AndroidApplication
        return DaggerArticleComponent.builder().initAppComponent(app.getInjector())
            .initActivity(activity).build()
    }
}