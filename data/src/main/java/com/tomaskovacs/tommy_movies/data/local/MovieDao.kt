package com.tomaskovacs.tommy_movies.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tomaskovacs.tommy_movies.data.local.model.MovieLocal

@Dao
interface MovieDao {

    @Query("SELECT * FROM $MOVIE_ENTITY WHERE category = :category")
    suspend fun getMoviesByCategory(category: String): List<MovieLocal>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movies: List<MovieLocal>)
}
