package com.example.login.di.modules

import android.app.Activity
import com.example.igdb.di.scope.FeatureScope
import com.example.igdb.external.helper.DialogHelper
import dagger.Module
import dagger.Provides

@Module
class ExternalModule {
    @Provides
    @FeatureScope
    fun provideDialogHelper(activity: Activity): DialogHelper {
        return DialogHelper(activity)
    }
}