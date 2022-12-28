package com.aleksadjordjevic.watchlist.presentation.home

import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.presentation.search.SearchEvent

sealed class HomeEvent{
    data class OnRemoveTrackedMovie(val movie:MovieData):HomeEvent()
}
