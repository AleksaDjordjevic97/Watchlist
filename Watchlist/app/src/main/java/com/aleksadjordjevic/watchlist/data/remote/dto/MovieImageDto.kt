package com.aleksadjordjevic.watchlist.data.remote.dto

import com.squareup.moshi.Json

data class MovieImageDto(
    @field:Json(name = "url")
    val imageUrl:String
)