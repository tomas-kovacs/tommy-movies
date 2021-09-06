package com.tomaskovacs.tommy_movies.data.remote

import com.tomaskovacs.tommy_movies.data.remote.model.MovieRemote

class MoviesRemoteDataSourceImpl(private val api: MoviesApi) : MoviesRemoteDataSource {
    override suspend fun getMovies(): List<MovieRemote>? {
        return try {
            // TODO: add the apiKey
            api.getPopularMovies("").results
        } catch (e: Exception) {
            // TODO: handle exception
            null
        }
    }
}
