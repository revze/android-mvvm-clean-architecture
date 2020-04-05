package com.example.feature_article.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.feature_article.R
import com.example.feature_article.di.Injector
import com.example.igdb.data.model.Article
import com.example.igdb.external.GlideApp
import com.example.igdb.external.constants.ActivityConstant.ArticleDetailActivity.ARTICLE_ID
import com.example.igdb.external.constants.ActivityConstant.ArticleDetailActivity.ARTICLE_TITLE
import com.example.igdb.external.extensions.hide
import com.example.igdb.external.extensions.show
import com.example.igdb.external.helper.TextHelper
import com.example.igdb.presentation.base.BaseViewModelFactory
import kotlinx.android.synthetic.main.activity_article_detail.*
import javax.inject.Inject
import com.example.igdb.R as appR

class ArticleDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory<ArticleDetailViewModel>

    @Inject
    lateinit var textHelper: TextHelper

    private lateinit var viewModel: ArticleDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.create(this).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = intent.getStringExtra(ARTICLE_TITLE)

        viewModel = ViewModelProvider(this, viewModelFactory)[ArticleDetailViewModel::class.java]

        viewModel.loadingLiveData.observe(this, loadingObserver)
        viewModel.articleLiveData.observe(this, articleObserver)
        viewModel.errorLiveData.observe(this, errorObserver)

        viewModel.getArticle(intent.getIntExtra(ARTICLE_ID, 0))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private val loadingObserver = Observer<Boolean> {
        pb.show()
        sv_content.hide()
        tv_error.hide()
    }

    private val articleObserver = Observer<Article> {
        pb.hide()
        sv_content.show()
        tv_error.hide()

        val article = it
        GlideApp.with(this).load(article.image)
            .placeholder(appR.drawable.bg_placeholder_square).into(iv_article)
        tv_summary.text = article.summary
        tv_author.text = article.author
        tv_published_date.text =
            textHelper.convertLongToFormattedDate(article.publishedAt, "EEEE, d MMMM yyyy")
    }

    private val errorObserver = Observer<String> {
        pb.hide()
        sv_content.hide()
        tv_error.show()
        tv_error.text = it
    }
}
