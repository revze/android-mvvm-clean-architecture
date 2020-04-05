package com.example.igdb.external.helper

import android.app.Activity
import android.content.Intent
import com.example.igdb.external.constants.ActivityConstant.GamesDetailActivity
import com.example.igdb.external.constants.ActivityConstant.LoginActivity
import javax.inject.Inject

class ActivityNavigation @Inject constructor(private val activity: Activity) {
    fun toLogin() {
        createIntent(LoginActivity.ACTIVITY)
    }

    fun toGamesDetail(gamesId: Int, gamesName: String) {
        createIntent(GamesDetailActivity.ACTIVITY) {
            it.putExtra(GamesDetailActivity.GAMES_ID, gamesId)
            it.putExtra(GamesDetailActivity.GAMES_NAME, gamesName)
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