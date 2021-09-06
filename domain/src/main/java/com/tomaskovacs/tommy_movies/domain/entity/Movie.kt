package com.tomaskovacs.tommy_movies.domain.entity

data class Movie(
    val id: Int,
    val title: String,
    val backdropPath: String,
    val releaseDate: String
)
