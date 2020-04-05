package com.example.feature_games.data.repository

import android.app.Application
import com.example.igdb.data.datasource.remote.IgdbRemoteDataSource
import com.example.igdb.data.model.Games
import com.example.igdb.data.services.api.NetworkBoundResource
import com.example.igdb.data.services.api.Resource
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(private val application: Application, private val remoteDataSource: IgdbRemoteDataSource): GamesRepository {
    override suspend fun getGamesDetail(id: Int): Resource<Games> {
        return object : NetworkBoundResource<Games>(application) {
            override suspend fun networkCall(): Games {
                return remoteDataSource.getGames(id, "name, artworks.*, screenshots.*, rating, summary, genres.*, platforms.*, rating, release_dates.*, websites.*")[0]
            }

            override fun isOfflineFirstEnabled() = false

            override suspend fun loadFromCache(): Games? {
                TODO("Not yet implemented")
            }

            override suspend fun insertToCache(data: Games) {
                TODO("Not yet implemented")
            }

        }.build()
    }
}