package com.example.cinemavault.domain.Model

data class CategoriesModel(
    val genres: List<CategoriesItemModel> = emptyList()
)
data class CategoriesItemModel(
    val id: Int=1,
    val name: String=""
)