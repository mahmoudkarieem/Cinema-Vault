package com.example.cinemavault.presentation.viewModels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemavault.domain.Model.CategoriesItemModel
import com.example.cinemavault.domain.use_cases.CategoryUseCase
import com.example.cinemavault.domain.utils.CategoryState
import com.example.cinemavault.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    val categoryUseCase: CategoryUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CategoryState())

    private val _categoryState = mutableStateOf(CategoriesItemModel())

    val state: State<CategoryState>
        get() = _state


    val categoryState: State<CategoriesItemModel>
        get() = _categoryState

    fun getCategory(category: CategoriesItemModel) {
        _categoryState.value = category
        _categoryState.value = _categoryState.value
        Log.d("CategoryViewModel", "State updated: ${state.value}")
    }

    init {
        getCategoriesList()
    }

    private fun getCategoriesList() {
        categoryUseCase(lang = Locale.current.language)
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {

                        _state.value = CategoryState(
                            success = result.data?.genres ?: emptyList(),
                            loading = false
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = CategoryState(
                            loading = true
                        )
                    }

                    is Resource.Error -> {
                        _state.value = CategoryState(
                            error = "Unexpected error: ${result.message}"
                        )
                        Log.e("CategoryViewModel", "Error fetching categories: ${result.message}")
                    }
                }

            }.launchIn(viewModelScope)
    }
}