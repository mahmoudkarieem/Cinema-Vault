package com.example.cinemavault.presentation.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinemavault.domain.use_cases.MoviesUseCase
import com.example.cinemavault.domain.utils.MoviesState
import com.example.cinemavault.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {

    private val _stateMovies = mutableStateOf(MoviesState())
    val stateMovies: State<MoviesState> get() = _stateMovies


    fun getMovies(categoryId: String) {
        moviesUseCase(language = Locale.current.language, catsId = categoryId)
            .onEach { result ->
                _stateMovies.value = when (result) {
                    is Resource.Success -> MoviesState(success = result.data)
                    is Resource.Loading -> MoviesState(loading = true)
                    is Resource.Error -> MoviesState(error = "Unexpected error occurred")
                }
            }
            .launchIn(viewModelScope)
    }
}

