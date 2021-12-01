package com.tomaskovacs.tommy_movies.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tomaskovacs.tommy_movies.hasInternetConnection
import com.tomaskovacs.tommy_movies.ui.HomeScreen
import com.tomaskovacs.tommy_movies.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { HomeScreen(viewModel) }
        viewModel.getMovies(hasInternetConnection())
    }
}
