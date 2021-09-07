package com.tomaskovacs.tommy_movies.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tomaskovacs.tommy_movies.data.local.MOVIE_ENTITY

@Entity(tableName = MOVIE_ENTITY)
data class MovieLocal(
    @PrimaryKey val id: Int,
    val title: String,
    val backdropPath: String,
    val releaseDate: String
)
