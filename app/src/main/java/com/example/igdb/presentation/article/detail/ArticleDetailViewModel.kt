package com.example.igdb.presentation.article.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.igdb.data.services.api.Resource
import com.example.igdb.domain.common.State
import com.example.igdb.data.model.Article
import com.example.igdb.domain.usecase.article.GetArticleDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleDetailViewModel @Inject constructor(private val useCase: GetArticleDetailUseCase): ViewModel() {
    val state = MutableLiveData<State<Article>>()

    fun getArticleDetail(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        withContext(Dispatchers.Main) {
            state.value = State.Loading()
        }
        when (val result = useCase(id)) {
            is Resource.Success -> state.postValue(State.Success(result.data))
            is Resource.Error -> state.postValue(State.Error(result.message))
        }
    }
}