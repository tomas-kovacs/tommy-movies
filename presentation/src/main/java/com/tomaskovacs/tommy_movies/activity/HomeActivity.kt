package com.tomaskovacs.tommy_movies.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.tomaskovacs.tommy_movies.adapter.MoviesAdapter
import com.tomaskovacs.tommy_movies.base.BaseActivity
import com.tomaskovacs.tommy_movies.databinding.ActivityHomeBinding
import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMoviesList()
        viewModel.moviesLiveData.observe(this, moviesObserver)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMovies()
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
        // Remove the snack and instead go to the movie detail (sending the movie id)
        Snackbar.make(binding.root, movie.title, Snackbar.LENGTH_SHORT).show()
    }

    override fun getBindingClass(): ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
}
