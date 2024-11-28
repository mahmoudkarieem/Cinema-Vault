package com.example.cinemavault.domain.Model

data class MoviesModel(
    val page: Int=0,
    val results: List<MoviesItemModel> = emptyList(),
    val totalPages: Int,
    val totalResults: Int
)
data class MoviesItemModel(
    val genreIds: List<Int> = emptyList(),
    val id: Int=0,
    val title: String="",
    val posterPath: String="",
    val voteCount: Int=0,
    val voteAverage: Double=1.0,
)