package com.example.belajardagger.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<T : ViewModel> : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory<T>

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    internal lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        viewModel = getViewModelProvider()

        onActivityReady(savedInstanceState)
    }

    internal abstract fun getLayoutId(): Int

    internal abstract fun onActivityReady(savedInstanceState: Bundle?)

    internal abstract fun getViewModelProvider(): T

    override fun androidInjector() = androidInjector
}