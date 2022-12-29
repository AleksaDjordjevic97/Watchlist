package com.aleksadjordjevic.watchlist.domain.use_case

import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository
import com.aleksadjordjevic.watchlist.domain.util.Resource

class SearchMovie(
    private val repository:MovieRepository
) {
    suspend operator fun invoke(
        query:String
    ) :Result<List<MovieData>>{
        return if(query.isBlank()) {
            Result.success(emptyList())
        } else {
            repository.searchForMovie(query.trim())
        }
    }
}