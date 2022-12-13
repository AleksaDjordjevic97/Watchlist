package com.aleksadjordjevic.watchlist.domain.use_case

import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository
import com.aleksadjordjevic.watchlist.domain.util.Resource

class SearchMovie(
    private val repository:MovieRepository
) {
    suspend operator fun invoke(
        query:String,
        page:Int = 1,
        pageSize:Int = 40
    ) :Result<List<MovieData>>{
        if(query.isBlank()) {
            return Result.success(emptyList())
        } else {
            return repository.searchForMovie(query.trim())
        }
    }
}