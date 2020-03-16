package com.example.igdb.presentation.article.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.igdb.R
import com.example.igdb.data.model.Article
import com.example.igdb.domain.common.State
import com.example.igdb.external.GlideApp
import com.example.igdb.external.extensions.hide
import com.example.igdb.external.extensions.show
import com.example.igdb.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_article_detail.*

class ArticleDetailActivity : BaseActivity<ArticleDetailViewModel>() {
    companion object {
        const val ID = "id"
        const val TITLE = "title"
    }

    override fun getLayoutId() = R.layout.activity_article_detail

    override fun onActivityReady(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = intent.getStringExtra(TITLE)

        viewModel.state.observe(this, observer)
        viewModel.getArticleDetail(intent.getIntExtra(ID, 0))
    }

    private val observer = Observer<State<Article>> {
        when (it) {
            is State.Loading -> {
                pb.show()
                sv_content.hide()
                tv_error.hide()
            }
            is State.Error -> {
                pb.hide()
                sv_content.hide()
                tv_error.text = it.message
                tv_error.show()
            }
            is State.Success -> {
                pb.hide()
                sv_content.show()
                tv_error.hide()

                val article = it.data
                GlideApp.with(this).load(article.image)
                    .placeholder(R.drawable.bg_placeholder_square).into(iv_article)
                tv_summary.text = article.summary
                tv_author.text = article.author
                tv_published_date.text =
                    textHelper.convertLongToFormattedDate(article.publishedAt, "EEEE, d MMMM yyyy")
            }
        }
    }

    override fun getViewModelProvider() =
        ViewModelProvider(this, viewModelFactory)[ArticleDetailViewModel::class.java]

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
