package com.tomaskovacs.tommy_movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tomaskovacs.tommy_movies.databinding.ItemMovieBinding
import com.tomaskovacs.tommy_movies.domain.entity.Movie
import kotlin.properties.Delegates

class MoviesAdapter(
    private val onMovieClick: (movie: Movie) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    var movies: List<Movie> by Delegates.observable(emptyList()) { _, oldList, newList ->
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = oldList.size

            override fun getNewListSize(): Int = newList.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                newList[newItemPosition].id == oldList[oldItemPosition].id

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                newList[newItemPosition] == oldList[oldItemPosition]
        }).dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                Glide.with(root.context).load(IMAGE_BASE_URL + movie.backdropPath).into(ivMovieImage)
                tvMovieTitle.text = movie.title
                tvMovieReleaseDate.text = root.context.getString(R.string.movie_release_date, movie.releaseDate)
                root.setOnClickListener { onMovieClick(movie) }
            }
        }
    }

    companion object {
        private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"
    }
}
