package com.example.cinemavault.presentation.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemavault.domain.use_cases.TrendingUseCase
import com.example.cinemavault.domain.utils.Resource
import com.example.cinemavault.domain.utils.TrendingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class TrendingViewModel @Inject constructor(
    private val trendingUseCase: TrendingUseCase
) : ViewModel() {

    private val _state = mutableStateOf(TrendingState())
    val state: State<TrendingState>
        get() = _state

    init {
        getTrendingMovies()
    }

    private fun getTrendingMovies() {
        trendingUseCase(lang = Locale.current.language).onEach { result ->
            _state.value = when (result) {
                is Resource.Success -> TrendingState(success = result.data?.results ?: emptyList())
                is Resource.Loading -> TrendingState(isLoading = true)
                is Resource.Error -> TrendingState(error = result.message.toString())

            }

        }.launchIn(viewModelScope)

    }
}