package com.tomaskovacs.tommy_movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomaskovacs.tommy_movies.R
import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.domain.entity.MovieCategory
import com.tomaskovacs.tommy_movies.domain.usecase.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase) : ViewModel() {

    private val _moviesLiveData: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>()
    }
    val moviesLiveData: LiveData<List<Movie>> = _moviesLiveData

    fun onCategorySelected(hasInternetConnection: Boolean, id: Int) = viewModelScope.launch {
        val category = when (id) {
            R.id.chip_home_top_rated -> MovieCategory.TOP_RATED
            R.id.chip_home_upcoming -> MovieCategory.UPCOMING
            R.id.chip_home_latest -> MovieCategory.LATEST
            R.id.chip_home_now_playing -> MovieCategory.NOW_PLAYING
            else -> MovieCategory.POPULAR
        }

        getMovies(hasInternetConnection, category)
    }

    private suspend fun getMovies(hasInternetConnection: Boolean, category: MovieCategory = MovieCategory.POPULAR) {
        _moviesLiveData.value = moviesUseCase.getMovies(hasInternetConnection, category)
    }
}
