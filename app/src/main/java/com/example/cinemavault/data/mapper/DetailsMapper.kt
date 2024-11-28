package com.example.cinemavault.data.mapper

import com.example.cinemavault.data.remote.dto.detailsDto.DetailsDto
import com.example.cinemavault.data.remote.dto.detailsDto.GenreDto
import com.example.cinemavault.data.remote.dto.detailsDto.ProductionCompanyDto
import com.example.cinemavault.domain.Model.DetailsModel
import com.example.cinemavault.domain.Model.GenreModel
import com.example.cinemavault.domain.Model.ProductionCompanyModel
import javax.inject.Inject

class DetailsMapper @Inject constructor() {
    fun fromRemoteDetailsToModel(obj: DetailsDto): DetailsModel {
        return DetailsModel(
            adult = obj.adult,
            posterPath = obj.posterPath,
            voteAverage = obj.voteAverage,
            title = obj.title,
            video = obj.video,
            status = obj.status,
            originalLanguage = obj.originalLanguage,
            id = obj.id,
            budget = obj.budget,
            genres = fromRemoteGenreToModel(obj.genres),
            productionCompanies = fromRemoteProductionCompanyToModel(obj.productionCompanies),
            overview = obj.overview
        )
    }

    private fun fromRemoteGenreToModel(obj: List<GenreDto>): List<GenreModel> {
        return obj.map {
            GenreModel(
                name = it.name,
                id = it.id
            )
        }

    }

    private fun fromRemoteProductionCompanyToModel(obj: List<ProductionCompanyDto>): List<ProductionCompanyModel> {
        return obj.map {
            ProductionCompanyModel(
                id = it.id,
                name = it.name,
                originCountry = it.originCountry,
                logoPath = it.logoPath
            )
        }
    }
}