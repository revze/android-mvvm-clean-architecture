package com.example.feature_article.data.repository

import com.example.igdb.data.model.Article
import com.example.igdb.data.services.api.Resource

interface ArticleRepository {
    suspend fun getArticleDetail(id: Int): Resource<Article>

    suspend fun getArticles(): Resource<List<Article>>
}