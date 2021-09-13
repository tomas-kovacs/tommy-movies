package com.tomaskovacs.tommy_movies.data.remote

import com.tomaskovacs.tommy_movies.data.BuildConfig
import com.tomaskovacs.tommy_movies.data.remote.model.MovieDetailRemote
import com.tomaskovacs.tommy_movies.data.remote.model.MovieRemote

class MoviesRemoteDataSourceImpl(private val api: MoviesApi) : MoviesRemoteDataSource {
    override suspend fun getMovies(category: String): List<MovieRemote>? {
        return try {
            api.getPopularMovies(category, BuildConfig.API_KEY).results
        } catch (e: Exception) {
            // TODO: handle exception
            null
        }
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetailRemote? {
        return try {
            api.getMovieDetail(movieId, BuildConfig.API_KEY)
        } catch (e: Exception) {
            // TODO: handle exception
            null
        }
    }
}
