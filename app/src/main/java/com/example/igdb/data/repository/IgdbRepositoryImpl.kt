package com.example.igdb.data.repository

import android.app.Application
import com.example.igdb.data.services.api.Resource
import com.example.igdb.data.datasource.local.IgdbLocalDataSource
import com.example.igdb.data.services.api.NetworkBoundResource
import com.example.igdb.data.model.Article
import com.example.igdb.data.model.Games
import com.example.igdb.data.datasource.remote.IgdbRemoteDataSource
import javax.inject.Inject

class IgdbRepositoryImpl @Inject constructor(
    private val remoteDataSource: IgdbRemoteDataSource,
    private val localDataSource: IgdbLocalDataSource,
    private val application: Application
) : IgdbRepository {
    override suspend fun getGames(): Resource<List<Games>> {
        return object : NetworkBoundResource<List<Games>>(application) {
            override suspend fun networkCall() =
                remoteDataSource.getGames("name, artworks.*, screenshots.*, rating, summary")

            override fun shouldLoadFromCache() = true

            override suspend fun loadFromCache(): List<Games> {
                return localDataSource.getGames()
            }

            override suspend fun insertToCache(data: List<Games>) {
                localDataSource.insertGames(data)
            }
        }.build()
    }

    override suspend fun getGames(id: Int): Resource<Games> {
        return object : NetworkBoundResource<Games>(application) {
            override suspend fun networkCall() =
                remoteDataSource.getGames(
                    id,
                    "name, artworks.*, screenshots.*, rating, summary, genres.*, platforms.*, rating, release_dates.*, websites.*"
                )[0]

            override suspend fun loadFromCache(): Games {
                return localDataSource.getGames(id)
            }

            override suspend fun insertToCache(data: Games) {
                localDataSource.insertGames(data)
            }

            override fun shouldLoadFromCache() = true
        }.build()
    }

    override suspend fun getArticles(): Resource<List<Article>> {
        return object : NetworkBoundResource<List<Article>>(application) {
            override suspend fun networkCall() =
                remoteDataSource.getArticles("title, published_at, summary, image, author")

            override fun shouldLoadFromCache() = true

            override suspend fun loadFromCache() = localDataSource.getArticles()

            override suspend fun insertToCache(data: List<Article>) {
                localDataSource.insertArticles(data)
            }
        }.build()
    }

    override suspend fun getArticle(id: Int): Resource<Article> {
        return object : NetworkBoundResource<Article>(application) {
            override suspend fun networkCall() =
                remoteDataSource.getArticle(id, "title, published_at, summary, image, author, videos")[0]

            override fun shouldLoadFromCache() = true

            override suspend fun loadFromCache(): Article {
                return localDataSource.getArticle(id)
            }

            override suspend fun insertToCache(data: Article) {
                localDataSource.insertArticle(data)
            }
        }.build()
    }
}