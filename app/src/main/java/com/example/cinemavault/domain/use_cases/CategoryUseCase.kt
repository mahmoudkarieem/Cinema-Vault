package com.example.cinemavault.domain.use_cases

import com.example.cinemavault.domain.Model.CategoriesModel
import com.example.cinemavault.domain.repository.CategoriesRepository
import com.example.cinemavault.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val repository: CategoriesRepository
) {
    operator fun invoke(lang:String):Flow<Resource<CategoriesModel>> = flow {
        try {
            emit(Resource.Loading<CategoriesModel>())
            val response=repository.getCategoriesRepository(language = lang)
            emit(Resource.Success<CategoriesModel>(data = response))

        }catch (e:Exception){
            emit(Resource.Error<CategoriesModel>("${e.localizedMessage}  : Un expected error" ))
        }

    }
}