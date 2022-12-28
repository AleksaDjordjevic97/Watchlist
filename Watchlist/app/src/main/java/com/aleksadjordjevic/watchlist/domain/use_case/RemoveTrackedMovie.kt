package com.aleksadjordjevic.watchlist.domain.use_case

import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository

class RemoveTrackedMovie(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(
        movie: MovieData
    ) {
        repository.deleteMovie(movie)
    }
}