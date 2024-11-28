package com.example.cinemavault.data.repository

import com.example.cinemavault.data.mapper.MoviesMapper
import com.example.cinemavault.data.remote.api.MoviesApi
import com.example.cinemavault.domain.Model.MoviesModel
import com.example.cinemavault.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val mapper: MoviesMapper,
    private val api: MoviesApi


) : MoviesRepository {
    override suspend fun getMoviesRepository(
        language: String,
        page: Int,
        genesId: String
    ): MoviesModel {
        return mapper.fromMoviesDtoToModel(
            api.getMovies(
                language = language,
                generalId = genesId,
                page = page
            )
        )

    }
}