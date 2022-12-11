package com.aleksadjordjevic.watchlist.presentation.search

import com.aleksadjordjevic.watchlist.domain.movie.MovieData

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val trackableMovies:List<MovieData> = listOf(
        MovieData(
            id = "sfafas",
            title = "Avengers",
            year = 2012,
            imageUrl = "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"
        ),
        MovieData(
            id = "sfafas",
            title = "Avengers",
            year = 2012,
            imageUrl = "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"
        ),
    )
)