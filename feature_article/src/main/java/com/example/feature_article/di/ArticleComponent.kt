package com.example.feature_article.di

import com.example.feature_article.di.module.DataModule
import com.example.feature_article.di.module.DomainModule
import com.example.feature_article.di.module.ViewModelModule
import com.example.feature_article.presentation.ArticleDetailActivity
import com.example.igdb.di.AppComponent
import com.example.igdb.di.scope.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    modules = [DataModule::class, DomainModule::class, ViewModelModule::class],
    dependencies = [AppComponent::class]
)
interface ArticleComponent {
    @Component.Factory
    interface Builder {
        fun create(appComponent: AppComponent): ArticleComponent
    }

    fun inject(activity: ArticleDetailActivity)
}