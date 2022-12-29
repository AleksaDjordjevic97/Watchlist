package com.aleksadjordjevic.watchlist.data.remote

import com.aleksadjordjevic.watchlist.data.remote.dto.SearchDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface MoviesAPI {

    @Headers("x-rapidapi-key: 5f39fa7ea0msh119966530ef9163p188c05jsn57711eb967b2")
    @GET("titles/search/title/{title}?titleType=movie&exact=false&limit=10")
    suspend fun searchForMoviesByTitle(
        @Path("title") title: String
    ): SearchDto

    companion object {
        const val BASE_URL = "https://moviesdatabase.p.rapidapi.com/"
    }
}