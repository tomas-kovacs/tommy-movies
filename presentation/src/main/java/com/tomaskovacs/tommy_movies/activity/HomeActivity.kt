package com.tomaskovacs.tommy_movies.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomaskovacs.tommy_movies.R
import com.tomaskovacs.tommy_movies.activity.MovieDetailActivity.Companion.EXTRA_MOVIE_ID
import com.tomaskovacs.tommy_movies.adapter.MoviesAdapter
import com.tomaskovacs.tommy_movies.base.BaseActivity
import com.tomaskovacs.tommy_movies.databinding.ActivityHomeBinding
import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.extension.hasInternetConnection
import com.tomaskovacs.tommy_movies.extension.startActivity
import com.tomaskovacs.tommy_movies.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMoviesList()
        observeChips()
        viewModel.moviesLiveData.observe(this, moviesObserver)
        viewModel.onCategorySelected(hasInternetConnection(), R.id.chip_home_popular)
    }

    private val moviesObserver = Observer<List<Movie>> { movies ->
        moviesAdapter.movies = movies
    }

    private fun initMoviesList() {
        moviesAdapter = MoviesAdapter(::onMovieClick)
        binding.rvHomeMovies.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun onMovieClick(movie: Movie) {
        startActivity<MovieDetailActivity> {
            putExtra(EXTRA_MOVIE_ID, movie.id)
        }
    }

    private fun observeChips() {
        binding.cgHomeCategories.setOnCheckedChangeListener { _, checkedId ->
            binding.rvHomeMovies.smoothScrollToPosition(0)
            viewModel.onCategorySelected(hasInternetConnection(), checkedId)
        }
    }

    override fun getBindingClass(): ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
}
