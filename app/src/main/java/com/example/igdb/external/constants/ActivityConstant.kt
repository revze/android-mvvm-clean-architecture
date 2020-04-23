package com.example.igdb.external.constants

object ActivityConstant {
    object LoginActivity {
        const val ACTIVITY = "com.example.login.presentation.login.LoginActivity"
    }

    object LoginEmailActivity {
        const val ACTIVITY = "com.example.login.presentation.loginemail.LoginEmailActivity"
    }

    object GamesDetailActivity {
        const val ACTIVITY =
            "com.example.feature_games.presentation.gamesdetail.GamesDetailActivity"
        const val GAMES_NAME = "games_name"
        const val GAMES_ID = "games_id"
    }

    object ArticleDetailActivity {
        const val ACTIVITY =
            "com.example.feature_article.presentation.articledetail.ArticleDetailActivity"
        const val ARTICLE_ID = "article_id"
        const val ARTICLE_TITLE = "article_title"
    }
}