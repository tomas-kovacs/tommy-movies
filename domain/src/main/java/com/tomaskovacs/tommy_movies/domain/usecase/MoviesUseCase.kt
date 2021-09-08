package com.tomaskovacs.tommy_movies.domain.usecase

import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.domain.entity.MovieDetail
import com.tomaskovacs.tommy_movies.domain.repository.MoviesRepository

class MoviesUseCase(private val repository: MoviesRepository) {
    suspend fun getMovies(forceUpdate: Boolean): List<Movie> = repository.getMovies(forceUpdate)
    suspend fun getMovieDetail(movieId: Int): MovieDetail? = repository.getMovieDetail(movieId)
}
