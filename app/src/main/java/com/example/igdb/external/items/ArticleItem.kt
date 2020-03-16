package com.example.igdb.external.items

import android.content.Intent
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.igdb.R
import com.example.igdb.data.model.Article
import com.example.igdb.external.GlideApp
import com.example.igdb.presentation.article.detail.ArticleDetailActivity
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_article.view.*
import kotlinx.android.synthetic.main.item_row_games.view.tv_title
import org.ocpsoft.prettytime.PrettyTime
import java.util.*

class ArticleItem(private val article: Article) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val view = viewHolder.containerView
        val context = view.context
        val prettyTime = PrettyTime()
        val date = Date(article.publishedAt * 1000)

        GlideApp.with(context)
                .load(article.image)
                .placeholder(R.drawable.bg_placeholder)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view.iv_image)
        view.tv_title.text = article.title
        view.tv_author.text = article.author
        view.tv_published_date.text = prettyTime.format(date)

        view.setOnClickListener {
            Intent(context, ArticleDetailActivity::class.java).apply {
                putExtra(ArticleDetailActivity.ID, article.id)
                putExtra(ArticleDetailActivity.TITLE, article.title)
                context.startActivity(this)
            }
        }
    }

    override fun getLayout() = R.layout.item_row_article
}