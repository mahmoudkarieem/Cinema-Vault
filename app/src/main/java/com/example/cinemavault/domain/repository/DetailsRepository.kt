package com.example.cinemavault.domain.repository

import com.example.cinemavault.domain.Model.DetailsModel

interface DetailsRepository {
    suspend fun getDetailsRepository(
        id: Int

    ): DetailsModel
}