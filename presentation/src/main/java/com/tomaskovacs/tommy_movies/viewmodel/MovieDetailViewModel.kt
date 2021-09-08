package com.tomaskovacs.tommy_movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomaskovacs.tommy_movies.domain.entity.MovieDetail
import com.tomaskovacs.tommy_movies.domain.usecase.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val useCase: MoviesUseCase) : ViewModel() {

    private val _moviesLiveData: MutableLiveData<MovieDetail?> by lazy {
        MutableLiveData<MovieDetail?>()
    }
    val moviesLiveData: LiveData<MovieDetail?> = _moviesLiveData

    fun getMovieDetail(movieId: Int?) = viewModelScope.launch {
        _moviesLiveData.value = if (movieId != null)
            useCase.getMovieDetail(movieId)
        else
            null
    }
}
