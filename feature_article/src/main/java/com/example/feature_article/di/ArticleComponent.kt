package com.example.feature_article.di

import android.app.Activity
import com.example.feature_article.di.module.DataModule
import com.example.feature_article.di.module.DomainModule
import com.example.feature_article.di.module.ViewModelModule
import com.example.feature_article.presentation.articledetail.ArticleDetailActivity
import com.example.feature_article.presentation.articlelist.ArticleListFragment
import com.example.igdb.di.AppComponent
import com.example.igdb.di.scope.FeatureScope
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    modules = [DataModule::class, DomainModule::class, ViewModelModule::class],
    dependencies = [AppComponent::class]
)
interface ArticleComponent {
    @Component.Builder
    interface Builder {
        fun initAppComponent(appComponent: AppComponent): Builder
        fun initActivity(@BindsInstance activity: Activity): Builder
        fun build(): ArticleComponent
    }

    fun inject(activity: ArticleDetailActivity)

    fun inject(fragment: ArticleListFragment)
}