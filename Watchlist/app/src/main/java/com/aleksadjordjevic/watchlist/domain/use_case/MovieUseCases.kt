package com.aleksadjordjevic.watchlist.domain.use_case

data class MovieUseCases(
    val searchMovie: SearchMovie,
    val trackMovie: TrackMovie,
    val getTrackedMovies: GetTrackedMovies
)
