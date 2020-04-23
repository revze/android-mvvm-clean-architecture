package com.example.igdb.di.modules

import com.example.igdb.external.helper.ActivityNavigation
import com.example.igdb.external.helper.DialogHelper
import com.example.igdb.presentation.base.BaseViewModelFactory
import com.example.igdb.presentation.main.MainActivity
import com.example.igdb.presentation.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun provideDialogHelper(activity: MainActivity): DialogHelper {
        return DialogHelper(activity)
    }

    @Provides
    fun provideMainViewModelFactory(viewModel: MainViewModel): BaseViewModelFactory<MainViewModel> {
        return BaseViewModelFactory { viewModel }
    }

    @Provides
    fun provideActivityNavigation(activity: MainActivity): ActivityNavigation {
        return ActivityNavigation(activity)
    }
}