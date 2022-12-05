package com.aleksadjordjevic.watchlist.data.repository

import com.aleksadjordjevic.watchlist.data.mappers.toMovieData
import com.aleksadjordjevic.watchlist.data.remote.MoviesAPI
import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository
import com.aleksadjordjevic.watchlist.domain.util.Resource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val moviesAPI: MoviesAPI
):MovieRepository {

    override suspend fun searchForMovie(title: String): Resource<MovieData> {
        return try{
            Resource.Success(
                data = moviesAPI
                    .searchForMoviesByTitle(title)
                    .toMovieData()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "And unknown error occured")
        }
    }

}