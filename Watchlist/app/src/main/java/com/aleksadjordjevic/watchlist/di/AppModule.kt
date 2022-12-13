package com.aleksadjordjevic.watchlist.di

import com.aleksadjordjevic.watchlist.data.remote.MoviesAPI
import com.aleksadjordjevic.watchlist.data.remote.MoviesAPI.Companion.BASE_URL
import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository
import com.aleksadjordjevic.watchlist.domain.use_case.MovieUseCases
import com.aleksadjordjevic.watchlist.domain.use_case.SearchMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
          .build()
    }

    @Provides
    @Singleton
    fun provideMovieApi(client: OkHttpClient): MoviesAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }


}