package com.tomaskovacs.tommy_movies.domain.usecase

import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.domain.repository.MoviesRepository

class GetMoviesUseCase(private val repository: MoviesRepository) {
    suspend operator fun invoke(forceUpdate: Boolean): List<Movie> = repository.getMovies(forceUpdate)
}
