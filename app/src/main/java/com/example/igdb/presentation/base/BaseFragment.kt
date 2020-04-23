package com.example.igdb.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    protected abstract fun getLayoutId(): Int

    protected abstract fun initDependencyInjection()

    protected open fun getViewModelProvider() {
        // Init viewmodel provider
    }

    protected abstract fun onFragmentReady(view: View, savedInstanceState: Bundle?)

    override fun onAttach(context: Context) {
        initDependencyInjection()
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViewModelProvider()
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

    protected val baseActivity: BaseActivity
        get() = requireActivity() as BaseActivity
}