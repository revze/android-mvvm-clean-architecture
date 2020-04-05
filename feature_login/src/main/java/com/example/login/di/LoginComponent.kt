package com.example.login.di

import android.app.Activity
import com.example.igdb.di.AppComponent
import com.example.igdb.di.scope.FeatureScope
import com.example.login.di.modules.DataModule
import com.example.login.di.modules.DomainModule
import com.example.login.di.modules.ExternalModule
import com.example.login.di.modules.ViewModelModule
import com.example.login.presentation.login.LoginActivity
import com.example.login.presentation.loginemail.LoginEmailActivity
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    modules = [DataModule::class, DomainModule::class, ViewModelModule::class, ExternalModule::class],
    dependencies = [AppComponent::class]
)
interface LoginComponent {
    @Component.Builder
    interface Builder {
        fun appComponent(appComponent: AppComponent): Builder
        fun activity(@BindsInstance activity: Activity): Builder
        fun build(): LoginComponent
    }

    fun inject(activity: LoginActivity)

    fun inject(activity: LoginEmailActivity)
}