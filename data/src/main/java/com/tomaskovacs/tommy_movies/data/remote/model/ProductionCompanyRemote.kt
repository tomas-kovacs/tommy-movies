package com.tomaskovacs.tommy_movies.data.remote.model

import com.google.gson.annotations.SerializedName

data class ProductionCompanyRemote(
    val name: String?,
    val id: Int?,
    @SerializedName("logo_path") val logoPath: String?,
    @SerializedName("origin_country") val originCountry: String?
)
