package com.aleksadjordjevic.watchlist.domain.use_case

import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetTrackedMovies(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<List<MovieData>> {
        return repository.getAllTrackedMovies()
    }
}