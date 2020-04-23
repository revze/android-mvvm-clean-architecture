package com.example.feature_article.data.repository

import android.app.Application
import com.example.igdb.data.datasource.local.IgdbLocalDataSource
import com.example.igdb.data.datasource.remote.IgdbRemoteDataSource
import com.example.igdb.data.model.Article
import com.example.igdb.data.services.api.NetworkBoundResource
import com.example.igdb.data.services.api.Resource
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val application: Application,
    private val localDataSource: IgdbLocalDataSource,
    private val remoteDataSource: IgdbRemoteDataSource
) : ArticleRepository {
    override suspend fun getArticleDetail(id: Int): Resource<Article> {
        return object : NetworkBoundResource<Article>(application) {
            override suspend fun networkCall(): Article {
                return remoteDataSource.getArticle(
                    id,
                    "title, published_at, summary, image, author, videos"
                )[0]
            }

            override fun isOfflineFirstEnabled() = true

            override suspend fun loadFromCache(): Article? {
                return localDataSource.getArticle(id)
            }

            override suspend fun insertToCache(data: Article) {
                localDataSource.insertArticle(data)
            }
        }.build()
    }

    override suspend fun getArticles(): Resource<List<Article>> {
        return object : NetworkBoundResource<List<Article>>(application) {
            override suspend fun networkCall(): List<Article> {
                return remoteDataSource.getArticles(
                    "title, published_at, summary, image, author"
                )
            }

            override fun isOfflineFirstEnabled() = true

            override suspend fun loadFromCache(): List<Article>? {
                return localDataSource.getArticles()
            }

            override suspend fun insertToCache(data: List<Article>) {
                localDataSource.insertArticles(data)
            }
        }.build()
    }
}