package com.example.cinemavault.presentation.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemavault.domain.use_cases.DetailsUseCase
import com.example.cinemavault.domain.utils.DetailsState
import com.example.cinemavault.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCase: DetailsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(DetailsState())
    val state: State<DetailsState>
        get() = _state


    fun getDetailsScreen(id: Int) {
        useCase(id = id)
            .onEach { result ->
                _state.value = when (result) {
                    is Resource.Success -> DetailsState(success = result.data)
                    is Resource.Loading -> DetailsState(loading = true)
                    is Resource.Error -> DetailsState(error = "Un expected error happend")

                }

            }
            .launchIn(viewModelScope)

    }
}