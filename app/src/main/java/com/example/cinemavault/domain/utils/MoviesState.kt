package com.example.cinemavault.domain.utils

import androidx.paging.Pager
import com.example.cinemavault.domain.Model.MoviesItemModel

data class MoviesState(
    val success: Pager<Int, MoviesItemModel> ?=null,
    val error:String="",
    val loading:Boolean=false

)
