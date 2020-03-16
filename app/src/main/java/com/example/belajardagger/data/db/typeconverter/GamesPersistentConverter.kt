package com.example.belajardagger.data.db.typeconverter

import androidx.room.TypeConverter
import com.example.belajardagger.data.model.Games.*
import com.squareup.moshi.Types

class GamesPersistentConverter {
    @TypeConverter
    fun storeScreenshotsToString(data: List<Screenshot>?): String? {
        val type = Types.newParameterizedType(List::class.java, Screenshot::class.java)
        val converter = BasePersistentConverter<Screenshot>(type)
        return converter.convertToString(data)
    }

    @TypeConverter
    fun storeStringToScreenshots(data: String): List<Screenshot>? {
        val type = Types.newParameterizedType(List::class.java, Screenshot::class.java)
        val converter = BasePersistentConverter<Screenshot>(type)
        return converter.convertToObject(data)
    }

    @TypeConverter
    fun storeWebsitesToString(data: List<Website>?): String? {
        val type = Types.newParameterizedType(List::class.java, Website::class.java)
        val converter = BasePersistentConverter<Website>(type)
        return converter.convertToString(data)
    }

    @TypeConverter
    fun storeStringToWebsites(data: String): List<Website>? {
        val type = Types.newParameterizedType(List::class.java, Website::class.java)
        val converter = BasePersistentConverter<Website>(type)
        return converter.convertToObject(data)
    }

    @TypeConverter
    fun storeReleaseDatesToString(data: List<ReleaseDate>?): String? {
        val type = Types.newParameterizedType(List::class.java, ReleaseDate::class.java)
        val converter = BasePersistentConverter<ReleaseDate>(type)
        return converter.convertToString(data)
    }

    @TypeConverter
    fun storeStringToReleaseDates(data: String): List<ReleaseDate>? {
        val type = Types.newParameterizedType(List::class.java, ReleaseDate::class.java)
        val converter = BasePersistentConverter<ReleaseDate>(type)
        return converter.convertToObject(data)
    }

    @TypeConverter
    fun storePlatformsToString(data: List<Platform>?): String? {
        val type = Types.newParameterizedType(List::class.java, Platform::class.java)
        val converter = BasePersistentConverter<Platform>(type)
        return converter.convertToString(data)
    }

    @TypeConverter
    fun storeStringToPlatforms(data: String): List<Platform>? {
        val type = Types.newParameterizedType(List::class.java, Platform::class.java)
        val converter = BasePersistentConverter<Platform>(type)
        return converter.convertToObject(data)
    }

    @TypeConverter
    fun storeGenresToString(data: List<Genre>?): String? {
        val type = Types.newParameterizedType(List::class.java, Genre::class.java)
        val converter = BasePersistentConverter<Genre>(type)
        return converter.convertToString(data)
    }

    @TypeConverter
    fun storeStringToGenres(data: String): List<Genre>? {
        val type = Types.newParameterizedType(List::class.java, Genre::class.java)
        val converter = BasePersistentConverter<Genre>(type)
        return converter.convertToObject(data)
    }
}