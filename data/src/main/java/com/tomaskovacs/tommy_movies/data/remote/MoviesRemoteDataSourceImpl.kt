package com.tomaskovacs.tommy_movies.data.remote

import com.tomaskovacs.tommy_movies.data.BuildConfig
import com.tomaskovacs.tommy_movies.data.remote.model.MovieRemote

class MoviesRemoteDataSourceImpl(private val api: MoviesApi) : MoviesRemoteDataSource {
    override suspend fun getMovies(): List<MovieRemote>? {
        return try {
            api.getPopularMovies(BuildConfig.API_KEY).results
        } catch (e: Exception) {
            // TODO: handle exception
            null
        }
    }
}
