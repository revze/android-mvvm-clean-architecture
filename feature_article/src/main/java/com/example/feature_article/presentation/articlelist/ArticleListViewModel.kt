package com.example.feature_article.presentation.articlelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_article.domain.usecase.GetArticleListUseCase
import com.example.igdb.data.model.Article
import com.example.igdb.data.services.api.Resource
import com.example.igdb.domain.common.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticleListViewModel @Inject constructor(private val getArticleListUseCase: GetArticleListUseCase) :
    ViewModel() {
    val result = MutableLiveData<State<List<Article>>>()

    fun getArticles() {
        result.value = State.Loading()

        viewModelScope.launch(Dispatchers.IO) {
            when (val useCase = getArticleListUseCase()) {
                is Resource.Success -> {
                    result.postValue(State.Success(useCase.data))
                }
                is Resource.Error -> {
                    result.postValue(State.Error(useCase.message))
                }
            }
        }
    }
}
