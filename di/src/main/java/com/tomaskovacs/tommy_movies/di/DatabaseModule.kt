package com.tomaskovacs.tommy_movies.di

import android.content.Context
import com.tomaskovacs.tommy_movies.data.local.AppDatabase
import com.tomaskovacs.tommy_movies.data.local.MovieDao
import com.tomaskovacs.tommy_movies.data.local.MoviesLocalDataSource
import com.tomaskovacs.tommy_movies.data.local.MoviesLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.buildAppDatabase(context)
    }

    @Provides
    fun providesMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }

    @Provides
    fun providesMoviesLocalDataSource(movieDao: MovieDao): MoviesLocalDataSource {
        return MoviesLocalDataSourceImpl(movieDao)
    }
}
