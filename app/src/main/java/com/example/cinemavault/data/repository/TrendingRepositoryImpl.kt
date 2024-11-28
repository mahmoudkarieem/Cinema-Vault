package com.example.cinemavault.data.repository

import com.example.cinemavault.data.mapper.TrendingMapper
import com.example.cinemavault.data.remote.api.MoviesApi
import com.example.cinemavault.domain.Model.TrendingMoviesModel
import com.example.cinemavault.domain.repository.TrendingMoviesRepository
import javax.inject.Inject

class TrendingRepositoryImpl @Inject constructor(
    private val trendingApi: MoviesApi,
    private val mapper: TrendingMapper

) : TrendingMoviesRepository {
    override suspend fun getMoviesTrending(language: String): TrendingMoviesModel {
        return mapper.fromTrendingDtoToModel(trendingApi.getTrendingMovies())
    }
}