package com.example.igdb.external.items

import android.content.Intent
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.igdb.R
import com.example.igdb.data.model.Games
import com.example.igdb.external.GlideApp
import com.example.igdb.presentation.games.detail.GamesDetailActivity
import com.example.igdb.external.extensions.hide
import com.example.igdb.external.extensions.show
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_games.view.*

class GamesItem(private val games: Games) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val view = viewHolder.containerView
        val context = view.context
        view.tv_title.text = games.name
        if (games.summary != null) {
            view.tv_summary.show()
            view.tv_summary.text = games.summary
        } else {
            view.tv_summary.hide()
        }

        val screenshots = games.screenshots
        val imageUrl = if (screenshots != null && screenshots.isNotEmpty()) {
            screenshots[0].url.replace("//", "https://").replace("t_thumb", "t_screenshot_med")
        } else ""

        GlideApp.with(context)
            .load(imageUrl)
            .placeholder(R.drawable.bg_placeholder)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view.iv_screenshot)

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