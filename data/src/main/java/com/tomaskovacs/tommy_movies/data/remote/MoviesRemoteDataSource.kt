package com.tomaskovacs.tommy_movies.data.remote

import com.tomaskovacs.tommy_movies.data.remote.model.MovieDetailRemote
import com.tomaskovacs.tommy_movies.data.remote.model.MovieRemote

interface MoviesRemoteDataSource {
    suspend fun getMovies(): List<MovieRemote>?
    suspend fun getMovieDetail(movieId: Int): MovieDetailRemote?
}
