package com.example.feature_games.data.repository

import com.example.igdb.data.model.Games
import com.example.igdb.data.services.api.Resource

interface GamesRepository {
    suspend fun getGamesDetail(id: Int): Resource<Games>
}