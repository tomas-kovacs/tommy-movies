package com.tomaskovacs.tommy_movies.di

import com.tomaskovacs.tommy_movies.data.local.MoviesLocalDataSource
import com.tomaskovacs.tommy_movies.data.remote.MoviesRemoteDataSource
import com.tomaskovacs.tommy_movies.data.repository.MoviesRepositoryImpl
import com.tomaskovacs.tommy_movies.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    fun providesMoviesRepository(
        remoteDataSource: MoviesRemoteDataSource,
        localDataSource: MoviesLocalDataSource
    ): MoviesRepository {
        return MoviesRepositoryImpl(remoteDataSource, localDataSource)
    }
}
