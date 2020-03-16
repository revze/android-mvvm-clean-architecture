package com.example.belajardagger.di.modules

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.belajardagger.data.services.api.UserKeyInterceptor
import com.example.belajardagger.data.datasource.remote.IgdbRemoteDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(application: Application): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(ChuckerInterceptor(application))
            .addInterceptor(UserKeyInterceptor()).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://api-v3.igdb.com").build()
    }

    @Singleton
    @Provides
    fun provideGamesService(retrofit: Retrofit): IgdbRemoteDataSource {
        return retrofit.create(IgdbRemoteDataSource::class.java)
    }
}