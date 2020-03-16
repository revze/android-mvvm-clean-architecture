package com.example.belajardagger.presentation.article.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.belajardagger.R
import com.example.belajardagger.domain.common.State
import com.example.belajardagger.data.model.Article
import com.example.belajardagger.presentation.base.BaseFragment
import com.example.belajardagger.external.extensions.hide
import com.example.belajardagger.external.items.ArticleItem
import com.example.belajardagger.external.extensions.show
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.articles_fragment.*

class ArticlesFragment : BaseFragment<ArticlesViewModel>() {

    companion object {
        fun newInstance() = ArticlesFragment()
    }

    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun getLayoutId() = R.layout.articles_fragment

    override fun getViewModelProvider() =
        ViewModelProvider(requireActivity(), viewModelFactory)[ArticlesViewModel::class.java]

    override fun onFragmentReady(view: View, savedInstanceState: Bundle?) {
        rv_articles.adapter = adapter

        viewModel.result.observe(viewLifecycleOwner, observer)
        viewModel.getArticles()
    }

    private val observer = Observer<State<List<Article>>> {
        when (it) {
            is State.Loading -> {
                rv_articles.hide()
                pb.show()
                tv_error.hide()
            }
            is State.Success -> {
                for (article in it.data) {
                    adapter.add(ArticleItem(article))
                }
                pb.hide()
                rv_articles.show()
                tv_error.hide()
            }
            is State.Error -> {
                pb.hide()
                rv_articles.hide()
                tv_error.show()
                tv_error.text = it.message
            }
        }
    }
}
