package com.aleksadjordjevic.watchlist.domain.repository

import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.domain.util.Resource

interface MovieRepository {

    suspend fun searchForMovie(title:String): Result<List<MovieData>>
}