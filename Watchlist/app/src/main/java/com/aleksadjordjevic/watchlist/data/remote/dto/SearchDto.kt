package com.aleksadjordjevic.watchlist.data.remote.dto

import com.squareup.moshi.Json

data class SearchDto(
    @field:Json(name = "results")
    val movies:List<MovieDto>
)