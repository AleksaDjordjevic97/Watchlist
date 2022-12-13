package com.aleksadjordjevic.watchlist.presentation.home

import com.aleksadjordjevic.watchlist.domain.movie.MovieData

data class HomeState(
    val trackedMovies:List<MovieData> = emptyList()
)
