package com.example.cinemavault.data.mapper

import com.example.cinemavault.data.local.entity.TrendingMoviesEntity
import com.example.cinemavault.data.remote.dto.trendingDto.MovieTrendingItemDto
import com.example.cinemavault.data.remote.dto.trendingDto.MoviesResponseDto
import com.example.cinemavault.domain.Model.MovieTrendingItemModel
import com.example.cinemavault.domain.Model.TrendingMoviesModel
import javax.inject.Inject

class TrendingMapper @Inject constructor() {

    fun fromTrendingDtoToModel(obj: MoviesResponseDto): TrendingMoviesModel {
        return TrendingMoviesModel(
            page = obj.page,
            results = fromTrendingItemDtoToModel(obj.results),
        )

    }

    private fun fromTrendingItemDtoToModel(obj: List<MovieTrendingItemDto>): List<MovieTrendingItemModel> {
        return obj.map {
            MovieTrendingItemModel(
                id = it.id,
                adult = it.adult,
                voteAverage = it.voteAverage,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                genreIds = it.genreIds,
                title = it.title,
                overview = it.overview,

                )
        }

    }
    fun fromEntitiesToModel(entities: List<TrendingMoviesEntity>): TrendingMoviesModel {
        return TrendingMoviesModel(
            results = entities.map { fromEntityToModel(it) }
        )
    }

    private fun fromEntityToModel(entity: TrendingMoviesEntity): MovieTrendingItemModel {
        return MovieTrendingItemModel(
            id = entity.id,
            adult = entity.adult,
            voteAverage = entity.voteAverage,
            posterPath = entity.posterPath,
            releaseDate = entity.releaseDate,
            genreIds = entity.genreIds,
            title = entity.title,
            overview = entity.overview
        )
    }

    // From Domain Model to Local Entity
    fun fromModelToEntities(model: TrendingMoviesModel): List<TrendingMoviesEntity> {
        return model.results.map { fromModelToEntity(it) }
    }

    private fun fromModelToEntity(model: MovieTrendingItemModel): TrendingMoviesEntity {
        return TrendingMoviesEntity(
            id = model.id,
            adult = model.adult,
            voteAverage = model.voteAverage,
            posterPath = model.posterPath,
            releaseDate = model.releaseDate,
            genreIds = model.genreIds,
            title = model.title,
            overview = model.overview
        )
    }
}