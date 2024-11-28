package com.example.cinemavault.domain.utils

import com.example.cinemavault.domain.Model.DetailsModel

data class DetailsState(
    val error: String = "",
    val success: DetailsModel? = null,
    val loading: Boolean = false
)
