package com.example.cinemavault.domain.Model

data class DetailsModel(
    val adult: Boolean,
    val posterPath: String,
    val voteAverage: Double,
    val title: String,
    val video: Boolean,
    val status: String,
    val originalLanguage: String,
    val id: Int,
    val budget: Int,
    val genres: List<GenreModel>,
    val productionCompanies: List<ProductionCompanyModel>,
    val overview: String,
)

data class GenreModel(

    val id: Int,

    val name: String
)

data class ProductionCompanyModel(
    val id: Int,

    val logoPath: Any,

    val name: String,

    val originCountry: String
)