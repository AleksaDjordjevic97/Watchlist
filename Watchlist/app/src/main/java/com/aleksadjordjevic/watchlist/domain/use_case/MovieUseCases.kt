package com.aleksadjordjevic.watchlist.domain.use_case

import com.aleksadjordjevic.watchlist.presentation.home.HomeEvent

data class MovieUseCases(
    val searchMovie: SearchMovie,
    val trackMovie: TrackMovie,
    val getTrackedMovies: GetTrackedMovies,
    val removeTrackedMovie: RemoveTrackedMovie
)
