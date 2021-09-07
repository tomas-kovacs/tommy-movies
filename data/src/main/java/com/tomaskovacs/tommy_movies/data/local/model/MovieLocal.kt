package com.tomaskovacs.tommy_movies.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tomaskovacs.tommy_movies.data.local.MOVIE_ENTITY

@Entity(tableName = MOVIE_ENTITY)
data class MovieLocal(
    @PrimaryKey val id: Int,
    val title: String,
    val posterPath: String,
    val releaseDate: String,
    val popularity: Double,
    val voteAverage: Double
)
