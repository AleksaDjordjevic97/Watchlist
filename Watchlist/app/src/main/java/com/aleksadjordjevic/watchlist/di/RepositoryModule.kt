package com.aleksadjordjevic.watchlist.di

import com.aleksadjordjevic.watchlist.data.repository.MovieRepositoryImpl
import com.aleksadjordjevic.watchlist.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ):MovieRepository
}