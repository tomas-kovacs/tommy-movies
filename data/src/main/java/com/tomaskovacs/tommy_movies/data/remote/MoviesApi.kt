package com.tomaskovacs.tommy_movies.data.remote

import com.tomaskovacs.tommy_movies.data.remote.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): MoviesResponse
}
