package com.aleksadjordjevic.watchlist.presentation.search

import com.aleksadjordjevic.watchlist.domain.movie.MovieData

sealed class SearchEvent {
    data class onQueryChange(val query:String):SearchEvent()
    object onSearch:SearchEvent()
    data class OnSearchFocusChange(val isFocused:Boolean):SearchEvent()
    data class OnTrackMovie(val movie:MovieData):SearchEvent()
}