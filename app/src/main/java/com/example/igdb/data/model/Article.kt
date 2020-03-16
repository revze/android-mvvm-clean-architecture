package com.example.igdb.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "ms_article")
data class Article (
    @PrimaryKey
    @ColumnInfo(name = "id")
    @field:Json(name = "id")
    val id: Int,

    @ColumnInfo(name = "author")
    @field:Json(name = "author")
    val author: String,

    @ColumnInfo(name = "image")
    @field:Json(name = "image")
    val image: String,

    @ColumnInfo(name = "published_at")
    @field:Json(name = "published_at")
    val publishedAt: Long,

    @ColumnInfo(name = "summary")
    @field:Json(name = "summary")
    val summary: String,

    @ColumnInfo(name = "title")
    @field:Json(name = "title")
    val title: String
)