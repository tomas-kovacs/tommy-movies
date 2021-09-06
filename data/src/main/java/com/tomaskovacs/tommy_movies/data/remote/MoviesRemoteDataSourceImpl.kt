package com.tomaskovacs.tommy_movies.data.remote

import com.tomaskovacs.tommy_movies.data.model.MovieRemote

class MoviesRemoteDataSourceImpl : MoviesRemoteDataSource {
    override suspend fun getMovies(): List<MovieRemote>? {
        TODO("Not yet implemented")
    }
}
