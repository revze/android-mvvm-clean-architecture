package com.example.belajardagger.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.belajardagger.data.db.dao.ArticleDao
import com.example.belajardagger.data.db.dao.GamesDao
import com.example.belajardagger.data.model.Article
import com.example.belajardagger.data.model.Games

@Database(entities = [Article::class, Games::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    abstract fun gamesDao(): GamesDao
}