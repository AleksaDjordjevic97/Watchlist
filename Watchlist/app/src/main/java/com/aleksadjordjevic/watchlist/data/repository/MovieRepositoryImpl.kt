package com.aleksadjordjevic.watchlist.data.repository

import com.aleksadjordjevic.watchlist.data.local.MovieDao
import com.aleksadjordjevic.watchlist.data.mappers.toMovieData
import com.aleksadjordjevic.watchlist.data.mappers.toTrackedMovieEntity
import com.aleksadjordjevic.watchlist.data.remote.MoviesAPI
import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val moviesAPI: MoviesAPI,
    private val dao: MovieDao
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

    override suspend fun insertMovie(movie: MovieData) {
        val trackedMovie = movie.toTrackedMovieEntity()
        dao.insertTrackedMovie(trackedMovie)
    }

    override suspend fun deleteMovie(movie: MovieData) {
        dao.deleteTrackedMovie(movie.toTrackedMovieEntity())
    }

    override fun getAllTrackedMovies(): Flow<List<MovieData>> {
        return dao.getAllTrackedMovies().map {entities ->
            entities.map {
                it.toMovieData()
            }
        }
    }

}