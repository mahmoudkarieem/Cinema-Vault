package com.example.cinemavault.data.repository

import com.example.cinemavault.data.mapper.DetailsMapper
import com.example.cinemavault.data.remote.api.MoviesApi
import com.example.cinemavault.domain.Model.DetailsModel
import com.example.cinemavault.domain.repository.DetailsRepository
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val mapper: DetailsMapper,
    private val api: MoviesApi

) : DetailsRepository {
    override suspend fun getDetailsRepository(id: Int): DetailsModel {
        return mapper.fromRemoteDetailsToModel(api.getDetailsById(id = id))
    }
}