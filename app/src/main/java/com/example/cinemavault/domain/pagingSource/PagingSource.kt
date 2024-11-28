package com.example.cinemavault.domain.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cinemavault.domain.Model.MoviesItemModel
import com.example.cinemavault.domain.repository.MoviesRepository

class PagingSource(
    private val repository: MoviesRepository,
    val catId: String,
    val language: String
) : PagingSource<Int, MoviesItemModel>() {
    override fun getRefreshKey(state: PagingState<Int, MoviesItemModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesItemModel> {
        return try {
            val page = params.key ?: 1
            val response =
                repository.getMoviesRepository(language = language, page = page, genesId = catId)
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1),
            )

        } catch (e: Exception) {
            LoadResult.Error(e)

        }
    }
}