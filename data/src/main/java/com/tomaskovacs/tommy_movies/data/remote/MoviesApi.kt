package com.tomaskovacs.tommy_movies.data.remote

import com.tomaskovacs.tommy_movies.data.remote.model.MovieDetailRemote
import com.tomaskovacs.tommy_movies.data.remote.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/{category}")
    suspend fun getPopularMovies(
        @Path("category") category: String,
        @Query("api_key") apiKey: String
    ): MoviesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): MovieDetailRemote
}
