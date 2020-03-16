package com.example.igdb.data.datasource.remote

import com.example.igdb.data.model.Article
import com.example.igdb.data.model.Games
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IgdbRemoteDataSource {
    @GET("/games")
    suspend fun getGames(@Query("fields") fields: String): List<Games>

    @GET("/games/{games_id}")
    suspend fun getGames(@Path("games_id") id: Int, @Query("fields") fields: String): List<Games>

    @GET("/pulses")
    suspend fun getArticles(@Query("fields") fields: String): List<Article>

    @GET("/pulses/{pulse_id}")
    suspend fun getArticle(@Path("pulse_id") id: Int, @Query("fields") fields: String): List<Article>
}