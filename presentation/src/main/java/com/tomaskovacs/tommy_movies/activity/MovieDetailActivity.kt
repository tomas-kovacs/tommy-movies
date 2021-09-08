package com.tomaskovacs.tommy_movies.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.tomaskovacs.tommy_movies.R
import com.tomaskovacs.tommy_movies.base.BaseActivity
import com.tomaskovacs.tommy_movies.common.IMAGE_BASE_URL
import com.tomaskovacs.tommy_movies.databinding.ActivityMovieDetailBinding
import com.tomaskovacs.tommy_movies.domain.entity.MovieDetail
import com.tomaskovacs.tommy_movies.extension.convertToCurrency
import com.tomaskovacs.tommy_movies.extension.loadImage
import com.tomaskovacs.tommy_movies.viewmodel.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding>() {

    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.moviesLiveData.observe(this, movieDetailObserver)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMovieDetail(intent.extras?.getInt(EXTRA_MOVIE_ID))
    }

    private val movieDetailObserver = Observer<MovieDetail?> { movieDetail ->
        movieDetail?.run {
            showMovieDetail(this)
        } ?: showGenericError()
    }

    private fun showMovieDetail(movieDetail: MovieDetail) {
        with(movieDetail) {
            loadImage(binding.ivMovieDetailImage, IMAGE_BASE_URL + backdropPath)
            binding.tvMovieDetailTitle.text = title
            binding.tvMovieDetailRating.text = voteAverage.toString()
            binding.tvMovieDetailDescription.text = tagline
            binding.tvMovieDetailOverview.text = overview
            binding.tvMovieDetailBudget.text = getString(R.string.movie_budget, budget.convertToCurrency())
            binding.tvMovieDetailRevenue.text = getString(R.string.movie_revenue, revenue.convertToCurrency())
        }
    }

    override fun getBindingClass() = ActivityMovieDetailBinding.inflate(layoutInflater)

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
    }
}
