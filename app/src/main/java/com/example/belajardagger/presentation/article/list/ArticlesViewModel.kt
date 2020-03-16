package com.example.belajardagger.presentation.article.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.belajardagger.data.services.api.Resource
import com.example.belajardagger.domain.common.State
import com.example.belajardagger.data.model.Article
import com.example.belajardagger.domain.usecase.article.GetArticlesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArticlesViewModel @Inject constructor(private val getArticlesUseCase: GetArticlesUseCase) : ViewModel() {
    val result = MutableLiveData<State<List<Article>>>()

    fun getArticles() {
        result.value = State.Loading()

        viewModelScope.launch(Dispatchers.IO) {
            when (val useCase = getArticlesUseCase()) {
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
