package com.example.igdb.di

import android.app.Application
import com.example.igdb.AndroidApplication
import com.example.igdb.data.datasource.remote.IgdbRemoteDataSource
import com.example.igdb.di.builder.ActivityBuilder
import com.example.igdb.di.modules.DatabaseModule
import com.example.igdb.di.modules.NetworkModule
import com.example.igdb.di.modules.RepositoryModule
import com.example.igdb.di.modules.UseCaseModule
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

    fun provideIgdbRemoteDataSource(): IgdbRemoteDataSource

    fun provideApplication(): Application
}