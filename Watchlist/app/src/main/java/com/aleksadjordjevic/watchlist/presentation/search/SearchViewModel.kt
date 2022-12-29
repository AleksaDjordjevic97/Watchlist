package com.aleksadjordjevic.watchlist.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.domain.use_case.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases
):ViewModel() {

    var state by mutableStateOf(SearchState())
        private set

    private var getTrackedMoviesJob: Job? = null

    init {
        refreshTrackedMovies()
    }

    fun onEvent(event: SearchEvent) {
        when(event) {
            is SearchEvent.onQueryChange -> {
                state = state.copy(
                    query = event.query,
                    isHintVisible = event.query.isBlank()
                )
            }
            is SearchEvent.onSearch -> {
                executeSearch()
            }
            is SearchEvent.OnTrackMovie -> {
                trackMovie(event)
            }
        }
    }

    private fun trackMovie(event: SearchEvent.OnTrackMovie) {
        viewModelScope.launch {
            if(isMovieTracked(movie = event.movie))
                movieUseCases.removeTrackedMovie(event.movie)
            else
                movieUseCases.trackMovie(event.movie)

            refreshTrackedMovies()
        }
    }

    private fun refreshTrackedMovies() {
        getTrackedMoviesJob?.cancel()
        getTrackedMoviesJob = movieUseCases
            .getTrackedMovies()
            .onEach { movies->
                state = state.copy(
                    trackedMovies = movies
                )
            }
            .launchIn(viewModelScope)
    }

    private fun executeSearch() {
        viewModelScope.launch {
            state = state.copy(
                isSearching = true,
                trackableMovies = emptyList()
            )
            movieUseCases.searchMovie(
                state.query)
                .onSuccess { movies ->
                    state = state.copy(
                        trackableMovies = movies,
                        isSearching = false
                    )
                }
                .onFailure {
                    state = state.copy(isSearching = false,)
                }
        }
    }

    fun isMovieTracked(movie:MovieData):Boolean {
        return state.trackedMovies.contains(movie)
    }
}