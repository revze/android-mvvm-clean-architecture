package com.example.login.di

import android.app.Activity
import com.example.igdb.AndroidApplication

object Injector {
    fun create( activity: Activity): LoginComponent {
        val application = activity.application as AndroidApplication
        return DaggerLoginComponent.builder().initAppComponent(application.getInjector()).initActivity(activity).build()
    }
}