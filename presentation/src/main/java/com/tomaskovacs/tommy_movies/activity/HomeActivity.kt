package com.tomaskovacs.tommy_movies.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.tomaskovacs.tommy_movies.domain.entity.Movie
import com.tomaskovacs.tommy_movies.hasInternetConnection
import com.tomaskovacs.tommy_movies.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { HomeScreen(viewModel) }
        viewModel.getMovies(hasInternetConnection())
    }
}

@Composable
fun HomeScreen(viewModel: MoviesViewModel) {
    val movies: List<Movie>? by viewModel.moviesLiveData.observeAsState(listOf())
    MoviesList(movies = movies ?: listOf())
}

@Composable
fun MoviesList(movies: List<Movie>) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(scaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState)) {
        LazyColumn {
            items(movies) { movie ->
                MovieItem(movie) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(message = movie.title)
                    }
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onMovieClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .clickable {
                onMovieClick()
            }
    ) {
        GlideImage(
            imageModel = IMAGE_BASE_URL + movie.posterPath,
            modifier = Modifier.height(512.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = movie.title,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = movie.releaseDate,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MovieItem(
        movie = Movie(
            1,
            "Title",
            "",
            "10/10/2021",
            9.0,
            9.0
        )
    ) {}
}

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original/"
