package com.aleksadjordjevic.watchlist.data.remote

import com.aleksadjordjevic.watchlist.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesAPI {

    @GET("/titles/search/title/{title}?titleType=movie&exact=false")
    suspend fun searchForMoviesByTitle(
        @Path("title") title: String
    ): MovieDto

    companion object {
        const val BASE_URL = "https://moviesdatabase.p.rapidapi.com/"
    }
}