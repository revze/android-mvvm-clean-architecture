package com.example.belajardagger.di

import android.app.Application
import com.example.belajardagger.AndroidApplication
import com.example.belajardagger.di.builder.ActivityBuilder
import com.example.belajardagger.di.modules.DatabaseModule
import com.example.belajardagger.di.modules.NetworkModule
import com.example.belajardagger.di.modules.RepositoryModule
import com.example.belajardagger.di.modules.UseCaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, NetworkModule::class, DatabaseModule::class, UseCaseModule::class, RepositoryModule::class, ActivityBuilder::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(application: AndroidApplication)
}