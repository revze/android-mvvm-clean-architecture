package com.example.igdb.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.igdb.R
import com.example.igdb.external.CustomViewPagerAdapter
import com.example.igdb.presentation.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_main

    override fun initDependencyInjection() {
        AndroidInjection.inject(this)
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        val fragments = mutableListOf<Fragment>()
        fragmentNavigation.getGamesList()?.let {
            fragments.add(it)
        }
        fragmentNavigation.getArticleList()?.let {
            fragments.add(it)
        }
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
