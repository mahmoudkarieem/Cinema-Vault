package com.example.cinemavault.domain.repository

import com.example.cinemavault.domain.Model.TrendingMoviesModel

interface TrendingMoviesRepository {

    suspend fun getMoviesTrending(
        language: String
    ): TrendingMoviesModel



}