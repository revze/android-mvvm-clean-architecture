package com.example.igdb.external.helper

import android.app.Activity
import android.content.Intent
import com.example.igdb.external.constants.ActivityConstant
import com.example.igdb.external.constants.ActivityConstant.ArticleDetailActivity
import com.example.igdb.external.constants.ActivityConstant.GamesDetailActivity
import com.example.igdb.external.constants.ActivityConstant.LoginActivity
import com.example.igdb.external.constants.ActivityConstant.LoginEmailActivity
import javax.inject.Inject

class ActivityNavigation @Inject constructor(private val activity: Activity) {
    fun toLogin() {
        createIntent(LoginActivity.ACTIVITY)
    }

    fun toLoginWithEmail() {
        createIntent(LoginEmailActivity.ACTIVITY)
    }

    fun toGamesDetail(gamesId: Int, gamesName: String) {
        createIntent(GamesDetailActivity.ACTIVITY) {
            it.putExtra(GamesDetailActivity.GAMES_ID, gamesId)
            it.putExtra(GamesDetailActivity.GAMES_NAME, gamesName)
        }
    }

    fun toArticleDetail(articleId: Int, articleTitle: String) {
        createIntent(ArticleDetailActivity.ACTIVITY) {
            it.putExtra(ArticleDetailActivity.ARTICLE_ID, articleId)
            it.putExtra(ArticleDetailActivity.ARTICLE_TITLE, articleTitle)
        }
    }

    private fun createIntent(activityTarget: String): Intent {
        return Intent(activity, Class.forName(activityTarget)).also {
            activity.startActivity(it)
        }
    }

    private fun createIntent(activityTarget: String, extras: (intent: Intent) -> Unit): Intent {
        return Intent(activity, Class.forName(activityTarget)).apply {
            extras(this)
        }.also {
            activity.startActivity(it)
        }
    }
}