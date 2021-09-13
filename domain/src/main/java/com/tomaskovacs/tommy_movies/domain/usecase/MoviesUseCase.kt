package com.tomaskovacs.tommy_movies.domain.usecase

import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.domain.entity.MovieCategory
import com.tomaskovacs.tommy_movies.domain.entity.MovieDetail
import com.tomaskovacs.tommy_movies.domain.repository.MoviesRepository

class MoviesUseCase(private val repository: MoviesRepository) {

    suspend fun getMovies(forceUpdate: Boolean, category: MovieCategory): List<Movie> =
        repository.getMovies(forceUpdate, category.suffix)

    suspend fun getMovieDetail(movieId: Int): MovieDetail? = repository.getMovieDetail(movieId)
}
