package com.example.belajardagger.external.items

import android.content.Intent
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.belajardagger.R
import com.example.belajardagger.data.model.Article
import com.example.belajardagger.presentation.article.detail.ArticleDetailActivity
import com.example.belajardagger.presentation.shared.GlideApp
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_article.view.*
import kotlinx.android.synthetic.main.item_row_games.view.tv_summary
import kotlinx.android.synthetic.main.item_row_games.view.tv_title

class ArticleItem(private val article: Article) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val view = viewHolder.containerView
        val context = view.context

        GlideApp.with(context).load(article.image).transition(DrawableTransitionOptions.withCrossFade()).into(view.iv_image)
        view.tv_title.text = article.title
        view.tv_summary.text = article.summary

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