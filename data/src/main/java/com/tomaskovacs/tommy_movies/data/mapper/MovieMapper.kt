package com.tomaskovacs.tommy_movies.data.mapper

import com.tomaskovacs.tommy_movies.data.model.MovieLocal
import com.tomaskovacs.tommy_movies.data.model.MovieRemote
import com.tomaskovacs.tommy_movies.domain.entity.Movie

fun MovieRemote.mapToMovie() = Movie(name)

fun MovieRemote.mapToMovieLocal() = MovieLocal(name)

fun MovieLocal.mapToMovie() = Movie(name)
