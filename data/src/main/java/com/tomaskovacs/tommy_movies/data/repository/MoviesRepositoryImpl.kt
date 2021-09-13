package com.tomaskovacs.tommy_movies.data.repository

import com.tomaskovacs.tommy_movies.data.local.MoviesLocalDataSource
import com.tomaskovacs.tommy_movies.data.mapper.mapToMovie
import com.tomaskovacs.tommy_movies.data.mapper.mapToMovieDetail
import com.tomaskovacs.tommy_movies.data.mapper.mapToMovieLocal
import com.tomaskovacs.tommy_movies.data.remote.MoviesRemoteDataSource
import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.domain.entity.MovieDetail
import com.tomaskovacs.tommy_movies.domain.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val localDataSource: MoviesLocalDataSource,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MoviesRepository {

    override suspend fun getMovies(forceUpdate: Boolean, category: String): List<Movie> = withContext(coroutineDispatcher) {
        if (forceUpdate)
            getMoviesRemote(category)
        else
            getMoviesLocal(category)
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetail? = withContext(coroutineDispatcher) {
        remoteDataSource.getMovieDetail(movieId)?.mapToMovieDetail()
    }

    private suspend fun getMoviesLocal(category: String): List<Movie> = localDataSource.getMovies(category)?.map { movieLocal ->
        movieLocal.mapToMovie()
    } ?: emptyList()

    private suspend fun getMoviesRemote(category: String): List<Movie> {
        val remoteMovies = remoteDataSource.getMovies(category)
        remoteMovies?.run {
            if (this.isNotEmpty())
                localDataSource.saveMovies(this.map { movieRemote -> movieRemote.mapToMovieLocal(category) })
        }

        return remoteMovies?.map { movieRemote -> movieRemote.mapToMovie() } ?: emptyList()
    }
}
