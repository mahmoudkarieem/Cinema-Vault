package com.example.cinemavault.data.remote.api

import com.example.cinemavault.data.Constants
import com.example.cinemavault.data.remote.dto.CategriesDto.CategoriesDto
import com.example.cinemavault.data.remote.dto.MoviesDto.MoviesDto
import com.example.cinemavault.data.remote.dto.detailsDto.DetailsDto
import com.example.cinemavault.data.remote.dto.trendingDto.MoviesResponseDto
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("genre/movie/list?api_key=${Constants.API_KEY}")
    suspend fun getCategories(
        @Query("language") language: String
    ): CategoriesDto

    @GET("discover/movie?api_key=${Constants.API_KEY}")
    suspend fun getMovies(
        @Query("language") language: String = "en",
        @Query("page") page: Int,
        @Query("with_genres") generalId: String
    ): MoviesDto

    @GET("trending/movie/day?api_key=${Constants.API_KEY}")
    suspend fun getTrendingMovies(
        @Query("language") language: String = "en-US",
    ): MoviesResponseDto


    @GET("movie/{movie_id}?api_key=${Constants.API_KEY}")
    suspend fun getDetailsById(
        @Path("movie_id") id: Int,
        @Query("language") language: String = "en-US"
    ): DetailsDto
}