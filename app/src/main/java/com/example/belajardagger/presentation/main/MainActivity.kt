package com.example.belajardagger.presentation.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.belajardagger.R
import com.example.belajardagger.presentation.article.list.ArticlesFragment
import com.example.belajardagger.presentation.base.BaseActivity
import com.example.belajardagger.presentation.games.list.GamesFragment
import com.example.belajardagger.external.CustomViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {

    override fun getLayoutId() = R.layout.activity_main

    override fun getViewModelProvider() =
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

    override fun onActivityReady(savedInstanceState: Bundle?) {
        val fragments =
            arrayListOf(
                GamesFragment.newInstance(),
                ArticlesFragment.newInstance()
            )
        val adapter = CustomViewPagerAdapter(
            supportFragmentManager,
            fragments
        )
        vp.adapter = adapter

        bn.setOnNavigationItemSelectedListener {
            if (it.itemId == R.id.action_article) {
                vp.currentItem = 1
            } else {
                vp.currentItem = 0
            }
            true
        }
    }
}
