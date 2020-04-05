package com.example.igdb.di.builder

import com.example.igdb.di.modules.MainModule
import com.example.igdb.di.scope.ActivityScope
import com.example.igdb.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, MainFragmentBuilder::class])
    abstract fun bindMainActivity(): MainActivity
}