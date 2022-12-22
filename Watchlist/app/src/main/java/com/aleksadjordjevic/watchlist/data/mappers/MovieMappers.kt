package com.aleksadjordjevic.watchlist.data.mappers

import com.aleksadjordjevic.watchlist.data.local.entity.TrackedMovieEntity
import com.aleksadjordjevic.watchlist.data.remote.dto.MovieDto
import com.aleksadjordjevic.watchlist.domain.movie.MovieData

fun MovieDto.toMovieData(): MovieData{
    return MovieData(
        id = id,
        title = title.title,
        year = year?.year ?: -1,
        imageUrl = imageUrl?.imageUrl ?: ""
    )
}

fun MovieData.toTrackedMovieEntity(): TrackedMovieEntity{
    return TrackedMovieEntity(
        imdbId = id,
        title = title,
        year = year,
        imageUrl = imageUrl
    )
}

fun TrackedMovieEntity.toMovieData():MovieData {
    return MovieData(
        id = imdbId,
        title = title,
        year = year,
        imageUrl = imageUrl
    )
}