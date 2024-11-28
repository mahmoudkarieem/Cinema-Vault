package com.example.cinemavault.domain.repository

import com.example.cinemavault.domain.Model.CategoriesModel

interface CategoriesRepository {
  suspend  fun getCategoriesRepository(
        language: String
    ):CategoriesModel
}