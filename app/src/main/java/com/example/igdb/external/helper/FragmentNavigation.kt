package com.example.igdb.external.helper

import androidx.fragment.app.Fragment
import com.example.igdb.external.constants.FragmentConstant
import com.example.igdb.external.constants.FragmentConstant.ArticleListFragment
import com.example.igdb.external.extensions.loadClassOrNull
import javax.inject.Inject

class FragmentNavigation @Inject constructor() {
    fun getArticleList(): Fragment? {
        return ArticleListFragment.FRAGMENT.loadClassOrNull<Fragment>()?.newInstance()
    }

    fun getGamesList(): Fragment? {
        return FragmentConstant.GamesListFragment.FRAGMENT.loadClassOrNull<Fragment>()
            ?.newInstance()
    }
}