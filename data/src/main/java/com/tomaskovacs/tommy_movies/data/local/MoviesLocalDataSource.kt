package com.tomaskovacs.tommy_movies.data.local

import com.tomaskovacs.tommy_movies.data.local.model.MovieLocal

interface MoviesLocalDataSource {
    suspend fun getMovies(category: String): List<MovieLocal>?
    suspend fun saveMovies(movies: List<MovieLocal>)
}
