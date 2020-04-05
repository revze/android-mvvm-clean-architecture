package com.example.feature_games.data.repository

import android.app.Application
import com.example.igdb.data.datasource.local.IgdbLocalDataSource
import com.example.igdb.data.datasource.remote.IgdbRemoteDataSource
import com.example.igdb.data.model.Games
import com.example.igdb.data.services.api.NetworkBoundResource
import com.example.igdb.data.services.api.Resource
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(private val application: Application, private val localDataSource: IgdbLocalDataSource, private val remoteDataSource: IgdbRemoteDataSource): GamesRepository {
    override suspend fun getGamesDetail(id: Int): Resource<Games> {
        return object : NetworkBoundResource<Games>(application) {
            override suspend fun networkCall(): Games {
                return remoteDataSource.getGames(id, "name, artworks.*, screenshots.*, rating, summary, genres.*, platforms.*, rating, release_dates.*, websites.*")[0]
            }

            override fun isOfflineFirstEnabled() = true

            override suspend fun loadFromCache(): Games? {
                return localDataSource.getGames(id)
            }

            override suspend fun insertToCache(data: Games) {
                localDataSource.insertGames(data)
            }

        }.build()
    }
}