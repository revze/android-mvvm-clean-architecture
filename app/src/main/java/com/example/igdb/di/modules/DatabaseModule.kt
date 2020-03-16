package com.example.igdb.di.modules

import android.app.Application
import androidx.room.Room
import com.example.igdb.data.datasource.local.IgdbLocalDataSource
import com.example.igdb.data.datasource.local.IgdbLocalDataSourceImpl
import com.example.igdb.data.db.AppDatabase
import com.example.igdb.data.db.dao.ArticleDao
import com.example.igdb.data.db.dao.GamesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "igdb").fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideArticleDao(appDatabase: AppDatabase): ArticleDao {
        return appDatabase.articleDao()
    }

    @Singleton
    @Provides
    fun provideGamesDao(appDatabase: AppDatabase): GamesDao {
        return appDatabase.gamesDao()
    }

    @Singleton
    @Provides
    fun provideIgdbLocalDataSource(dataSourceImpl: IgdbLocalDataSourceImpl): IgdbLocalDataSource = dataSourceImpl
}