package com.example.cinemavault.data.mapper

import com.example.cinemavault.data.remote.dto.CategriesDto.CategoriesDto
import com.example.cinemavault.data.remote.dto.CategriesDto.CategoriesItemDto
import com.example.cinemavault.domain.Model.CategoriesItemModel
import com.example.cinemavault.domain.Model.CategoriesModel
import javax.inject.Inject

class CategoriesMapper @Inject constructor() {
    fun fromCategoriesDtoToModel(obj: CategoriesDto): CategoriesModel {
        return CategoriesModel(
            genres = obj.genres.map {
                fromCategoriesItemDtoToModel(it)

            }
        )
    }

    fun fromCategoriesItemDtoToModel(obj: CategoriesItemDto): CategoriesItemModel {
        return CategoriesItemModel(
            id = obj.id,
            name = obj.name,

            )
    }
}