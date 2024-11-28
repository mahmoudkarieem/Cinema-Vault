package com.example.cinemavault.domain.utils

import com.example.cinemavault.domain.Model.MovieTrendingItemModel
import com.example.cinemavault.domain.Model.TrendingMoviesModel

data class TrendingState(
    val isLoading: Boolean = false,
    val success: List<MovieTrendingItemModel> = emptyList(),
    val error: String = ""
)
