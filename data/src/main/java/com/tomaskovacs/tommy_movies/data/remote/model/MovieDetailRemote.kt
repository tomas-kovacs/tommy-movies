package com.tomaskovacs.tommy_movies.data.remote.model

import com.google.gson.annotations.SerializedName

data class MovieDetailRemote(
    val adult: Boolean?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    val budget: Int?,
    val genres: List<GenreRemote>?,
    val id: Int?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("original_title") val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String?,
    val revenue: Int?,
    val runtime: Int?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("vote_count") val voteCount: Int?
)
