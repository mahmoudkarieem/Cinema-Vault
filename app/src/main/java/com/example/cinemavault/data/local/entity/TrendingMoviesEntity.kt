package com.example.cinemavault.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.cinemavault.data.local.converters.ConvertersGeneralIds


@Entity(tableName = "movies_items_trending")
data class TrendingMoviesEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val overview: String = "",
    val posterPath: String? = "",
    val adult: Boolean = false,
    @TypeConverters(ConvertersGeneralIds::class)
    val genreIds: List<Int> = emptyList(),
    val voteAverage: Double = 0.0,
    val releaseDate: String = "",


    )