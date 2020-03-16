package com.example.belajardagger.external.items

import android.content.Intent
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.belajardagger.R
import com.example.belajardagger.data.model.Games
import com.example.belajardagger.presentation.games.detail.GamesDetailActivity
import com.example.belajardagger.presentation.shared.GlideApp
import com.example.belajardagger.external.extensions.hide
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_games.view.*

class GamesItem(private val games: Games) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val view = viewHolder.containerView
        val context = view.context
        view.tv_title.text = games.name
        if (games.summary != null) {
            view.tv_summary.text = games.summary
        } else {
            view.tv_summary.hide()
        }
        games.screenshots?.let {
            if (it.isNotEmpty()) {
                val url = it[0].url.replace("//", "https://").replace("t_thumb", "t_screenshot_med")
                GlideApp.with(context).load(url).transition(DrawableTransitionOptions.withCrossFade()).into(view.iv_screenshot)
            }
        }

        view.setOnClickListener {
            Intent(context, GamesDetailActivity::class.java).apply {
                putExtra(GamesDetailActivity.GAMES_ID, games.id)
                putExtra(GamesDetailActivity.GAMES_TITLE, games.name)
                context.startActivity(this)
            }
        }
    }

    override fun getLayout() = R.layout.item_row_games
}