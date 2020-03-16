package com.example.igdb.data.repository

import com.example.igdb.data.services.api.Resource
import com.example.igdb.data.model.Article
import com.example.igdb.data.model.Games

interface IgdbRepository {
    suspend fun getGames(): Resource<List<Games>>

    suspend fun getGames(id: Int): Resource<Games>

    suspend fun getArticles(): Resource<List<Article>>

    suspend fun getArticle(id: Int): Resource<Article>
}