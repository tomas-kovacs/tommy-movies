package com.tomaskovacs.tommy_movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class MoviesViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    private val _moviesLiveData: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>()
    }
    val moviesLiveData: LiveData<List<Movie>> = _moviesLiveData

    fun getMovies() = viewModelScope.launch {
        // TODO: handle forceUpdate depending on the internet connection
        _moviesLiveData.value = getMoviesUseCase(true)
    }
}