package com.aleksadjordjevic.watchlist.data.remote.dto

import com.squareup.moshi.Json

data class MovieDto(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "titleText")
    val title: MovieTitleDto,
    @field:Json(name = "releaseYear")
    val year: MovieYearDto,
    @field:Json(name = "primaryImage")
    val imageUrl: MovieImageDto
)