package com.example.cinemavault.domain.Model


data class TrendingMoviesModel(
    val page: Int = 0,
    val results: List<MovieTrendingItemModel> = emptyList(),

    )

data class MovieTrendingItemModel(
    val id: Int = 0,
    val title: String = "",
    val overview: String = "",
    val posterPath: String? = "",
    val adult: Boolean = false,
    val genreIds: List<Int> = emptyList(),
    val voteAverage: Double = 0.0,
    val releaseDate: String = "",


    )