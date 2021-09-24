package com.tomaskovacs.tommy_movies

import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.domain.usecase.GetMoviesUseCase
import com.tomaskovacs.tommy_movies.viewmodel.MoviesViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest : BaseViewModelTest() {

    @Mock
    private lateinit var getMoviesUseCase: GetMoviesUseCase
    private lateinit var viewModel: MoviesViewModel

    private val moviesMockList = listOf(
        Movie(1, "title", "path", "date", 1.0, 1.0)
    )

    @Before
    fun init() {
        viewModel = MoviesViewModel(getMoviesUseCase)
    }

    @Test
    fun `get movies with internet connection`(): Unit = runBlocking {
        `when`(getMoviesUseCase(true)).thenReturn(moviesMockList)
        viewModel.getMovies(true)
        verify(getMoviesUseCase).invoke(true)
        assert(viewModel.moviesLiveData.value == moviesMockList)
    }

    @Test
    fun `get movies without internet connection`(): Unit = runBlocking {
        `when`(getMoviesUseCase(false)).thenReturn(moviesMockList)
        viewModel.getMovies(false)
        verify(getMoviesUseCase).invoke(false)
        assert(viewModel.moviesLiveData.value == moviesMockList)
    }

    @Test
    fun `get movies failure`(): Unit = runBlocking {
        `when`(getMoviesUseCase(true)).thenReturn(null)
        viewModel.getMovies(true)
        verify(getMoviesUseCase).invoke(true)
        assert(viewModel.moviesLiveData.value == null)
    }
}
