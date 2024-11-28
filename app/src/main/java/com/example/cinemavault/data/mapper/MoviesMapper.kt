package com.example.cinemavault.data.mapper

import com.example.cinemavault.data.remote.dto.MoviesDto.MoviesDto
import com.example.cinemavault.data.remote.dto.MoviesDto.MoviesItemDto
import com.example.cinemavault.domain.Model.MoviesItemModel
import com.example.cinemavault.domain.Model.MoviesModel
import javax.inject.Inject

class MoviesMapper @Inject constructor(){
    fun fromMoviesDtoToModel(obj: MoviesDto): MoviesModel {
        return MoviesModel(
            page = obj.page,
            results =fromMoviesItemToModel(obj.results),
            totalResults = obj.totalResults,
            totalPages = obj.totalPages,

            )
    }

    private fun fromMoviesItemToModel(obj: List<MoviesItemDto>): List<MoviesItemModel> {
        return obj.map {
            MoviesItemModel(
                id = it.id,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage,
                genreIds = it.genreIds,
                title = it.title,
                posterPath = it.posterPath
            )
        }
        }
    }
