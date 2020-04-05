package com.example.feature_article.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feature_article.domain.usecase.GetArticleDetailUseCase
import com.example.igdb.data.model.Article
import com.example.igdb.data.services.api.Resource
import com.example.igdb.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticleDetailViewModel @Inject constructor(private val useCase: GetArticleDetailUseCase): BaseViewModel() {
    val articleLiveData = MutableLiveData<Article>()

    fun getArticle(id: Int) {
        loadingLiveData.value = true

        viewModelScope.launch(Dispatchers.IO) {
            when(val result = useCase(id)) {
                is Resource.Success -> {
                    loadingLiveData.postValue(false)
                    articleLiveData.postValue(result.data)
                }
                is Resource.Error -> {
                    loadingLiveData.postValue(false)
                    errorLiveData.postValue(result.message)
                }
            }
        }
    }
}