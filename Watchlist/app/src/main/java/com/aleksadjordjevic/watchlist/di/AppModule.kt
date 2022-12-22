package com.aleksadjordjevic.watchlist.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aleksadjordjevic.watchlist.data.local.MovieDatabase
import com.aleksadjordjevic.watchlist.data.remote.MoviesAPI
import com.aleksadjordjevic.watchlist.data.remote.MoviesAPI.Companion.BASE_URL
import com.aleksadjordjevic.watchlist.data.repository.MovieRepositoryImpl
import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository
import com.aleksadjordjevic.watchlist.domain.use_case.MovieUseCases
import com.aleksadjordjevic.watchlist.domain.use_case.SearchMovie
import dagger.Binds
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

    @Provides
    @Singleton
    fun provideMovieDatabase(
        app:Application
    ):MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "movie_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        api:MoviesAPI,
        db:MovieDatabase
    ):MovieRepository {
        return MovieRepositoryImpl(
            moviesAPI = api,
            dao = db.dao
        )
    }


}