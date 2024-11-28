package com.example.cinemavault.domain.use_cases

import com.example.cinemavault.domain.Model.TrendingMoviesModel
import com.example.cinemavault.domain.repository.TrendingMoviesRepository
import com.example.cinemavault.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingUseCase @Inject constructor(
    private val repository: TrendingMoviesRepository
) {

    operator fun invoke(lang: String): Flow<Resource<TrendingMoviesModel>> = flow {
        try {
            emit(Resource.Loading<TrendingMoviesModel>())
            val response = repository.getMoviesTrending(language = lang)
            emit(Resource.Success<TrendingMoviesModel>(data = response))


        } catch (e: Exception) {
            emit(Resource.Error<TrendingMoviesModel>(message = "${e.localizedMessage?.toString()} Un Expected Error happen"))
        }
    }
}