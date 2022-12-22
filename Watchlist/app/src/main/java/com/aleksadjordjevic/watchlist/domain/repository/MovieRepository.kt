package com.aleksadjordjevic.watchlist.domain.repository

import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun searchForMovie(title:String): Result<List<MovieData>>

    suspend fun insertMovie(movie:MovieData)

    suspend fun deleteMovie(movie:MovieData)

    fun getAllTrackedMovies(): Flow<List<MovieData>>
}