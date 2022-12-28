package com.aleksadjordjevic.watchlist.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aleksadjordjevic.watchlist.domain.use_case.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases
):ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    private var getTrackedMoviesJob: Job? = null

    init {
        refreshTrackedMovies()
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

    fun onEvent(event:HomeEvent){
        when(event){
            is HomeEvent.OnRemoveTrackedMovie->{
                viewModelScope.launch {
                    movieUseCases.removeTrackedMovie(event.movie)
                    refreshTrackedMovies()
                }
            }
        }
    }
}