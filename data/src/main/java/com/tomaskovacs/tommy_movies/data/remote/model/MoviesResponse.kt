package com.tomaskovacs.tommy_movies.data.remote.model

import com.google.gson.annotations.SerializedName
import com.tomaskovacs.tommy_movies.data.remote.model.MovieRemote

data class MoviesResponse(
    val page: Int?,
    val results: List<MovieRemote>?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("total_results") val totalResults: Int?
)
