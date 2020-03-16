package com.example.igdb.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.igdb.data.model.Article

@Dao
interface ArticleDao {
    @Query("SELECT * FROM ms_article")
    suspend fun getAll(): List<Article>

    @Query("SELECT * FROM ms_article WHERE id = :id")
    suspend fun findById(id: Int): Article

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<Article>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)
}