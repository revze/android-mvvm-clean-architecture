package com.example.belajardagger.data.model

import androidx.room.*
import com.example.belajardagger.data.db.typeconverter.GamesPersistentConverter
import com.squareup.moshi.Json

@Entity(tableName = "ms_games")
@TypeConverters(GamesPersistentConverter::class)
data class Games(
    @PrimaryKey
    @ColumnInfo(name = "id")
    @field:Json(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    @field:Json(name = "name")
    val name: String,

    @ColumnInfo(name = "summary")
    @field:Json(name = "summary")
    val summary: String?,

    @ColumnInfo(name = "screenshots")
    @field:Json(name = "screenshots")
    val screenshots: List<Screenshot>?,

    @ColumnInfo(name = "rating")
    @field:Json(name = "rating")
    val rating: Double?,

    @ColumnInfo(name = "websites")
    @field:Json(name = "websites")
    val websites: List<Website>?,

    @ColumnInfo(name = "release_dates")
    @field:Json(name = "release_dates")
    val releaseDates: List<ReleaseDate>?,

    @ColumnInfo(name = "platforms")
    @field:Json(name = "platforms")
    val platforms: List<Platform>?,

    @ColumnInfo(name = "genres")
    @field:Json(name = "genres")
    val genres: List<Genre>?
) {
    data class Screenshot(
        @field:Json(name = "image_id") val imageId: String,
        @field:Json(name = "url") val url: String
    )

    data class Website(
        @field:Json(name = "url") val url: String
    )

    data class ReleaseDate(
        @field:Json(name = "date") val date: Long
    )

    data class Platform(
        @field:Json(name = "name") val name: String
    )

    data class Genre(
        @field:Json(name = "name") val name: String
    )
}