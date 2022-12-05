package com.aleksadjordjevic.watchlist.data.remote.dto

import com.squareup.moshi.Json

data class MovieTitleDto(
    @field:Json(name = "text")
    val title:String
)
