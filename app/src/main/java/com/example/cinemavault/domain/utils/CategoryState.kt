package com.example.cinemavault.domain.utils

import com.example.cinemavault.domain.Model.CategoriesItemModel

data class CategoryState(
    val error:String="",
    val success:List<CategoriesItemModel> = emptyList(),
    val loading:Boolean=false
)
