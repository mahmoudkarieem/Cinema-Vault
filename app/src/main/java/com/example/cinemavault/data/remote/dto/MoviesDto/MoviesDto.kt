package com.example.cinemavault.data.remote.dto.MoviesDto


import com.google.gson.annotations.SerializedName

data class MoviesDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MoviesItemDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)