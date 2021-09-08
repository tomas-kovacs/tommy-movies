package com.tomaskovacs.tommy_movies.activity

import com.tomaskovacs.tommy_movies.base.BaseActivity
import com.tomaskovacs.tommy_movies.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding>() {
    override fun getBindingClass() = ActivityMovieDetailBinding.inflate(layoutInflater)

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
    }
}
