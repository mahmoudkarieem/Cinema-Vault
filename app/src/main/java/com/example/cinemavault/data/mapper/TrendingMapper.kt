package com.example.cinemavault.data.mapper

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
}