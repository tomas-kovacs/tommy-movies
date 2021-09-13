package com.tomaskovacs.tommy_movies.domain.repository

import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.domain.entity.MovieDetail

interface MoviesRepository {
    suspend fun getMovies(forceUpdate: Boolean, category: String): List<Movie>
    suspend fun getMovieDetail(movieId: Int): MovieDetail?
}
