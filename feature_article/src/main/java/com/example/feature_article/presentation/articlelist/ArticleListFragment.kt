package com.example.feature_article.presentation.articlelist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.feature_article.R
import com.example.feature_article.di.Injector
import com.example.igdb.data.model.Article
import com.example.igdb.domain.common.State
import com.example.igdb.external.extensions.hide
import com.example.igdb.external.extensions.show
import com.example.igdb.external.items.ArticleItem
import com.example.igdb.presentation.base.BaseFragment
import com.example.igdb.presentation.base.BaseViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_article_list.*
import javax.inject.Inject

class ArticleListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory<ArticleListViewModel>

    private val adapter = GroupAdapter<GroupieViewHolder>()

    private lateinit var viewModel: ArticleListViewModel

    override fun getLayoutId() = R.layout.fragment_article_list

    override fun initDependencyInjection() {
        Injector.create(requireActivity()).inject(this)
    }

    override fun getViewModelProvider() {
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[ArticleListViewModel::class.java]
    }

    override fun onFragmentReady(view: View, savedInstanceState: Bundle?) {
        viewModel.result.observe(viewLifecycleOwner, observer)

        rv_articles.adapter = adapter
        sr_articles.setOnRefreshListener {
            adapter.clear()
            viewModel.getArticles()
        }
        viewModel.getArticles()
    }

    private val observer = Observer<State<List<Article>>> {
        when (it) {
            is State.Loading -> {
                sr_articles.isRefreshing = false
                sr_articles.isEnabled = false
                rv_articles.hide()
                pb.show()
                tv_error.hide()
            }
            is State.Success -> {
                sr_articles.isEnabled = true
                for (article in it.data) {
                    adapter.add(ArticleItem(article) {
                        baseActivity.activityNavigation.toArticleDetail(article.id, article.title)
                    })
                }
                pb.hide()
                rv_articles.show()
                tv_error.hide()
            }
            is State.Error -> {
                sr_articles.isEnabled = true
                pb.hide()
                rv_articles.hide()
                tv_error.show()
                tv_error.text = it.message
            }
        }
    }
}
