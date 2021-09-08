package com.tomaskovacs.tommy_movies.di

import com.tomaskovacs.tommy_movies.domain.repository.MoviesRepository
import com.tomaskovacs.tommy_movies.domain.usecase.MoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {
    @Provides
    fun providesGetMoviesUseCase(repository: MoviesRepository): MoviesUseCase {
        return MoviesUseCase(repository)
    }
}
