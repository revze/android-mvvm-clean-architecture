package com.example.igdb.data.db.dao

import androidx.room.*
import com.example.igdb.data.model.Games

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

    @Query("DELETE FROM ms_games")
    suspend fun deleteAll()
}