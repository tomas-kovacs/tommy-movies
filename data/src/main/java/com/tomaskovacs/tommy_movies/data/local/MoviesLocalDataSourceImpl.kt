package com.tomaskovacs.tommy_movies.data.local

import android.util.Log
import com.tomaskovacs.tommy_movies.data.local.model.MovieLocal

class MoviesLocalDataSourceImpl : MoviesLocalDataSource {
    override suspend fun getMovies(): List<MovieLocal>? {
        // TODO: implement
        Log.d("Movies", "Get movies from local database")
        return null
    }

    override suspend fun saveMovies(movies: List<MovieLocal>) {
        // TODO: implement
        Log.d("Movies", "Save movies to local database")
    }
}
