package com.tomaskovacs.tommy_movies.domain.entity

data class Movie(
    val id: Int,
    val title: String,
    val posterPath: String,
    val releaseDate: String,
    val popularity: Double,
    val voteAverage: Double
)
