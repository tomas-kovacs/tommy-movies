package com.tomaskovacs.tommy_movies.data.mapper

import com.tomaskovacs.tommy_movies.data.local.model.MovieLocal
import com.tomaskovacs.tommy_movies.data.remote.model.MovieRemote
import com.tomaskovacs.tommy_movies.domain.entity.Movie

fun MovieRemote.mapToMovie() = Movie(
    id = id ?: -1,
    title = title ?: "",
    posterPath = posterPath ?: "",
    releaseDate = releaseDate ?: "",
    popularity = popularity ?: 0.0,
    voteAverage = voteAverage ?: 0.0
)

fun MovieRemote.mapToMovieLocal() = MovieLocal(
    id = id ?: -1,
    title = title ?: "",
    posterPath = posterPath ?: "",
    releaseDate = releaseDate ?: "",
    popularity = popularity ?: 0.0,
    voteAverage = voteAverage ?: 0.0
)

fun MovieLocal.mapToMovie() = Movie(id, title, posterPath, releaseDate, popularity, voteAverage)
