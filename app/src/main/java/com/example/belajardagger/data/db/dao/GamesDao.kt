package com.example.belajardagger.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.belajardagger.data.model.Games

@Dao
interface GamesDao {
    @Query("SELECT * FROM ms_games")
    suspend fun getAll(): List<Games>

    @Query("SELECT * FROM ms_games WHERE id = :id")
    suspend fun findById(id: Int): Games

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(games: List<Games>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(games: Games)
}