package com.tomaskovacs.tommy_movies.data.repository

import com.tomaskovacs.tommy_movies.data.local.MoviesLocalDataSource
import com.tomaskovacs.tommy_movies.data.mapper.mapToMovie
import com.tomaskovacs.tommy_movies.data.mapper.mapToMovieLocal
import com.tomaskovacs.tommy_movies.data.remote.MoviesRemoteDataSource
import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.domain.repository.MoviesRepository

class MoviesRepositoryImpl(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val localDataSource: MoviesLocalDataSource
) : MoviesRepository {

    override suspend fun getMovies(forceUpdate: Boolean): List<Movie> {
        return if (forceUpdate)
            getMoviesRemote()
        else
            getMoviesLocal()
    }

    private suspend fun getMoviesLocal(): List<Movie> = localDataSource.getMovies()?.map { movieLocal ->
        movieLocal.mapToMovie()
    } ?: emptyList()

    private suspend fun getMoviesRemote(): List<Movie> {
        val remoteMovies = remoteDataSource.getMovies()
        remoteMovies?.run {
            if (this.isNotEmpty())
                localDataSource.saveMovies(this.map { movieRemote -> movieRemote.mapToMovieLocal() })
        }

        return remoteMovies?.map { movieRemote -> movieRemote.mapToMovie() } ?: emptyList()
    }
}
