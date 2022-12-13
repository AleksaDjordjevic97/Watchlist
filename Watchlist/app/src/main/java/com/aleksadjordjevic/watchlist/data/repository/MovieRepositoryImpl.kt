package com.aleksadjordjevic.watchlist.data.repository

import com.aleksadjordjevic.watchlist.data.mappers.toMovieData
import com.aleksadjordjevic.watchlist.data.remote.MoviesAPI
import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val moviesAPI: MoviesAPI
):MovieRepository {

    override suspend fun searchForMovie(title: String): Result<List<MovieData>> {
        return try{
            val searchDto = moviesAPI.searchForMoviesByTitle(title)

            Result.success(
                searchDto.movies
                    .filter { movie -> (movie.imageUrl?.imageUrl != null && movie.year?.year != null) }
                    .map { it.toMovieData() }
            )
        } catch (e: Exception) { e.printStackTrace()
            Result.failure(e)
        }
    }

}