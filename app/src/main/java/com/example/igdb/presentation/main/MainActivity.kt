package com.example.igdb.presentation.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.igdb.R
import com.example.igdb.external.CustomViewPagerAdapter
import com.example.igdb.presentation.article.list.ArticlesFragment
import com.example.igdb.presentation.base.BaseActivity
import com.example.igdb.presentation.games.list.GamesFragment
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
        vp.addOnPageChangeListener(object : CustomViewPagerAdapter.OnPageChangeListener {
            override fun onPageChanged(position: Int) {
                when (position) {
                    0 -> bn.selectedItemId = R.id.action_games
                    1 -> bn.selectedItemId = R.id.action_article
                }
            }
        })

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
