package com.aleksadjordjevic.watchlist.di

import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository
import com.aleksadjordjevic.watchlist.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object SearchModule {

    @Provides
    @ViewModelScoped
    fun provideMovieUseCases(
        repository: MovieRepository
    ): MovieUseCases {
        return MovieUseCases(
            searchMovie = SearchMovie(repository),
            trackMovie = TrackMovie(repository),
            getTrackedMovies = GetTrackedMovies(repository),
            removeTrackedMovie = RemoveTrackedMovie(repository)
        )
    }
}