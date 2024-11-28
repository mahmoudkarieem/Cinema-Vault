package com.example.cinemavault.domain.use_cases

import com.example.cinemavault.domain.Model.DetailsModel
import com.example.cinemavault.domain.repository.DetailsRepository
import com.example.cinemavault.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    val repository: DetailsRepository
) {
    operator fun invoke(id: Int): Flow<Resource<DetailsModel>> = flow {
        try {
            emit(Resource.Loading<DetailsModel>())
            val response = repository.getDetailsRepository(id = id)
            emit(Resource.Success<DetailsModel>(data = response))

        } catch (e: Exception) {
            emit(Resource.Error<DetailsModel>("${e.localizedMessage}  : Un expected error" ))
        }
    }
}