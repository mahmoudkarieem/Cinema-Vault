package com.example.cinemavault.data.repository

import com.example.cinemavault.data.local.dao.TrendingMoviesDao
import com.example.cinemavault.data.local.entity.TrendingMoviesEntity
import com.example.cinemavault.data.mapper.TrendingMapper
import com.example.cinemavault.data.remote.api.MoviesApi
import com.example.cinemavault.domain.Model.TrendingMoviesModel
import com.example.cinemavault.domain.repository.TrendingMoviesRepository
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class TrendingRepositoryImpl @Inject constructor(
    private val trendingApi: MoviesApi,
    private val mapper: TrendingMapper,
    private val dao: TrendingMoviesDao

) : TrendingMoviesRepository {
    override suspend fun getMoviesTrending(language: String): TrendingMoviesModel {
        val localMovies = fetchLocalMovies()
        if (localMovies != null) {
            return localMovies
        }

        // Fetch movies from API if not available locally
        val remoteMovies = fetchMoviesFromApi(language)

        // Save the fetched data locally
        saveMoviesToLocal(remoteMovies)

        return remoteMovies
    }

    private suspend fun fetchLocalMovies(): TrendingMoviesModel? {
        val localEntities = dao.getAll().firstOrNull()
        return if (!localEntities.isNullOrEmpty()) {
            mapper.fromEntitiesToModel(localEntities)
        } else {
            null
        }
    }

    private suspend fun fetchMoviesFromApi(language: String): TrendingMoviesModel {
        val response = trendingApi.getTrendingMovies(language)
        return mapper.fromTrendingDtoToModel(response)
    }

    private suspend fun saveMoviesToLocal(movies: TrendingMoviesModel) {
        val entities = mapper.fromModelToEntities(movies)
        dao.insertAll(entities)
    }
}