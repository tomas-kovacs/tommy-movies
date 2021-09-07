package com.tomaskovacs.tommy_movies.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.tomaskovacs.tommy_movies.base.BaseActivity
import com.tomaskovacs.tommy_movies.databinding.ActivityHomeBinding
import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.moviesLiveData.observe(this, moviesObserver)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMovies()
    }

    private val moviesObserver = Observer<List<Movie>> {
        // TODO: show movies in a recyclerView
    }

    override fun getBindingClass(): ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
}
