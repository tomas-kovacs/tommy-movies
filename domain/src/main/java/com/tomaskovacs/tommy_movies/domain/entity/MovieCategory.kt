package com.tomaskovacs.tommy_movies.domain.entity

enum class MovieCategory(val suffix: String) {
    POPULAR("popular"),
    TOP_RATED("top_rated"),
    UPCOMING("upcoming"),
    LATEST("latest"),
    NOW_PLAYING("now_playing")
}
