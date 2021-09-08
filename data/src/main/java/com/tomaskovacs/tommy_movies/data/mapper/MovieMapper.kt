package com.tomaskovacs.tommy_movies.data.mapper

import com.tomaskovacs.tommy_movies.data.local.model.MovieLocal
import com.tomaskovacs.tommy_movies.data.remote.model.MovieDetailRemote
import com.tomaskovacs.tommy_movies.data.remote.model.MovieRemote
import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.domain.entity.MovieDetail

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

fun MovieDetailRemote.mapToMovieDetail() = MovieDetail(
    adult ?: false,
    backdropPath ?: "",
    budget ?: 0,
    genres?.map { it.name ?: "" } ?: emptyList(),
    id ?: -1,
    originalLanguage ?: "",
    originalTitle ?: "",
    overview ?: "",
    popularity ?: 0.0,
    posterPath ?: "",
    releaseDate ?: "",
    revenue ?: 0,
    runtime ?: 0,
    status ?: "",
    tagline ?: "",
    title ?: "",
    video ?: false,
    voteAverage ?: 0.0,
    voteCount ?: 0,
)
