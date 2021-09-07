package com.tomaskovacs.tommy_movies.data.local

import com.tomaskovacs.tommy_movies.data.local.model.MovieLocal

class MoviesLocalDataSourceImpl(private val movieDao: MovieDao) : MoviesLocalDataSource {
    override suspend fun getMovies(): List<MovieLocal>? = movieDao.getAllMovies()

    override suspend fun saveMovies(movies: List<MovieLocal>) {
        movieDao.insertAllMovies(movies)
    }
}
