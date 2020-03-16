package com.example.belajardagger.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<T: ViewModel> : Fragment() {
    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory<T>

    internal lateinit var viewModel: T

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getViewModelProvider()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onFragmentReady(view, savedInstanceState)
    }

    internal abstract fun getLayoutId(): Int

    internal abstract fun getViewModelProvider(): T

    internal abstract fun onFragmentReady(view: View, savedInstanceState: Bundle?)
}