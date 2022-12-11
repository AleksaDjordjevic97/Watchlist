package com.aleksadjordjevic.watchlist.presentation.search

sealed class SearchEvent {
    data class onQueryChange(val query:String):SearchEvent()
    object onSearch:SearchEvent()
    data class OnSearchFocusChange(val isFocused:Boolean):SearchEvent()
}