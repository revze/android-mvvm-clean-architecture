package com.example.igdb.data.datasource.local

import com.example.igdb.data.model.Article
import com.example.igdb.data.model.Games

interface IgdbLocalDataSource {
    suspend fun getArticles(): List<Article>

    suspend fun getArticle(id: Int): Article

    suspend fun insertArticles(data: List<Article>)

    suspend fun insertArticle(data: Article)

    suspend fun getGames(): List<Games>

    suspend fun getGames(id: Int): Games

    suspend fun insertGames(data: List<Games>)

    suspend fun insertGames(data: Games)
}