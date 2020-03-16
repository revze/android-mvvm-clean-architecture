package com.example.belajardagger.presentation.article.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.belajardagger.R
import com.example.belajardagger.domain.common.State
import com.example.belajardagger.data.model.Article
import com.example.belajardagger.presentation.base.BaseActivity
import com.example.belajardagger.presentation.shared.GlideApp
import com.example.belajardagger.external.extensions.hide
import com.example.belajardagger.external.extensions.show
import kotlinx.android.synthetic.main.activity_article_detail.*
import java.text.SimpleDateFormat
import java.util.*

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
                GlideApp.with(this).load(article.image).into(iv_article)
                tv_summary.text = article.summary
                tv_author.text = article.author
                tv_published_date.text = convertLongToDate(article.publishedAt)
            }
        }
    }

    override fun getViewModelProvider() =
        ViewModelProvider(this, viewModelFactory)[ArticleDetailViewModel::class.java]

    private fun convertLongToDate(date: Long): String {
        val date2 = Date(date * 1000)
        val dateFormat = SimpleDateFormat("EEEE, d MMMM yyyy", Locale.getDefault())

        return dateFormat.format(date2.time)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
