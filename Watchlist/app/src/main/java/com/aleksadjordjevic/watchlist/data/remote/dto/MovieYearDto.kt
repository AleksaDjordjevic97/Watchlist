package com.aleksadjordjevic.watchlist.data.remote.dto

import com.squareup.moshi.Json

data class MovieYearDto(
    @field:Json(name = "year")
    val year:Int
)