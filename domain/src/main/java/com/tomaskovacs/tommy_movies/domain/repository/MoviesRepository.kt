package com.tomaskovacs.tommy_movies.domain.repository

import com.tomaskovacs.tommy_movies.domain.entity.Movie

interface MoviesRepository {
    suspend fun getMovies(forceUpdate: Boolean): List<Movie>?
}
