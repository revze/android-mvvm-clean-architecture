package com.example.belajardagger.data.datasource.local

import com.example.belajardagger.data.db.dao.ArticleDao
import com.example.belajardagger.data.db.dao.GamesDao
import com.example.belajardagger.data.model.Article
import com.example.belajardagger.data.model.Games
import javax.inject.Inject

class IgdbLocalDataSourceImpl @Inject constructor(
    private val articleDao: ArticleDao,
    private val gamesDao: GamesDao
) : IgdbLocalDataSource {
    override suspend fun getArticles(): List<Article> {
        return articleDao.getAll()
    }

    override suspend fun getArticle(id: Int): Article {
        return articleDao.findById(id)
    }

    override suspend fun insertArticles(data: List<Article>) {
        articleDao.insertAll(data)
    }

    override suspend fun insertArticle(data: Article) {
        articleDao.insert(data)
    }

    override suspend fun getGames(): List<Games> {
        return gamesDao.getAll()
    }

    override suspend fun getGames(id: Int): Games {
        return gamesDao.findById(id)
    }

    override suspend fun insertGames(data: List<Games>) {
        gamesDao.insertAll(data)
    }

    override suspend fun insertGames(data: Games) {
        gamesDao.insert(data)
    }
}