package com.example.cinemavault.domain.repository

import com.example.cinemavault.domain.Model.MoviesModel

interface MoviesRepository {
  suspend fun getMoviesRepository(
        language: String,
        page: Int,
        genesId: String
    ):MoviesModel
}