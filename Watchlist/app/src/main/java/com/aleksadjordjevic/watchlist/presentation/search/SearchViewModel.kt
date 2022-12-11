package com.aleksadjordjevic.watchlist.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(

):ViewModel() {

    var state by mutableStateOf(SearchState())
        private set

    fun onEvent(event: SearchEvent) {
        when(event) {
            is SearchEvent.onQueryChange -> {
                state = state.copy(query = event.query)
            }
            is SearchEvent.onSearch -> {
                executeSearch()
            }
            is SearchEvent.OnSearchFocusChange -> {
                state = state.copy(
                    isHintVisible = !event.isFocused && state.query.isBlank()
                )
            }
        }
    }

    private fun executeSearch() {

    }
}