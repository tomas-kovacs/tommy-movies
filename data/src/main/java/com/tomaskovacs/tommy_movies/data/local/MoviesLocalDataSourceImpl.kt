package com.tomaskovacs.tommy_movies.data.local

import com.tomaskovacs.tommy_movies.data.model.MovieLocal

class MoviesLocalDataSourceImpl : MoviesLocalDataSource {
    override suspend fun getMovies(): List<MovieLocal>? {
        TODO("Not yet implemented")
    }

    override suspend fun saveMovies(movies: List<MovieLocal>) {
        TODO("Not yet implemented")
    }
}
