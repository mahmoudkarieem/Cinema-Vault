package com.example.cinemavault.domain.use_cases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.cinemavault.domain.Model.MoviesItemModel
import com.example.cinemavault.domain.pagingSource.PagingSource
import com.example.cinemavault.domain.repository.MoviesRepository
import com.example.cinemavault.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(
        language: String,
        catsId: String,
    ): Flow<Resource<Pager<Int, MoviesItemModel>>> = flow {
        try {
            emit(Resource.Loading<Pager<Int, MoviesItemModel>>())
            val getMovies = Pager(
                pagingSourceFactory = {
                    PagingSource(
                        repository = repository,
                        language = language,
                        catId = catsId
                    )
                },
                config = PagingConfig(pageSize = 15)
            )
            emit(Resource.Success<Pager<Int, MoviesItemModel>>(data = getMovies))
        } catch (e: Exception) {
            emit(Resource.Error<Pager<Int, MoviesItemModel>>(message = "${e.localizedMessage} : un expected error happend"))
        }


    }
}