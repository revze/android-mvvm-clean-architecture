package com.example.igdb.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.igdb.external.helper.ActivityNavigation
import com.example.igdb.external.helper.DialogHelper
import com.example.igdb.external.helper.FragmentNavigation
import com.example.igdb.external.helper.TextHelper
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var activityNavigation: ActivityNavigation

    @Inject
    lateinit var fragmentNavigation: FragmentNavigation

    @Inject
    lateinit var dialogHelper: DialogHelper

    @Inject
    lateinit var textHelper: TextHelper

    protected abstract fun getLayoutId(): Int

    protected abstract fun onActivityReady(savedInstanceState: Bundle?)

    protected abstract fun initDependencyInjection()

    protected open fun getViewModelProvider() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencyInjection()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        getViewModelProvider()

        onActivityReady(savedInstanceState)
    }
}