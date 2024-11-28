package com.example.cinemavault.data.repository

import com.example.cinemavault.data.mapper.CategoriesMapper
import com.example.cinemavault.data.remote.api.MoviesApi
import com.example.cinemavault.domain.Model.CategoriesModel
import com.example.cinemavault.domain.repository.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val mapper: CategoriesMapper,
    private val api: MoviesApi
) : CategoriesRepository {
    override suspend fun getCategoriesRepository(language: String): CategoriesModel {
        return mapper.fromCategoriesDtoToModel(api.getCategories(language = language))
    }
}