package com.aleksadjordjevic.watchlist.presentation.search

import com.aleksadjordjevic.watchlist.domain.movie.MovieData

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = true,
    val isSearching: Boolean = false,
    val trackableMovies:List<MovieData> = emptyList(),
    val trackedMovies:List<MovieData> = emptyList()
)