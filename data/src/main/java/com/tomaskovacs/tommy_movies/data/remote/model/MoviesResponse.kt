package com.tomaskovacs.tommy_movies.data.remote.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val page: Int?,
    val results: List<MovieRemote>?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("total_results") val totalResults: Int?
)
