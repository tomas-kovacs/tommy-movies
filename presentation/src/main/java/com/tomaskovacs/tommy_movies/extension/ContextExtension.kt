package com.tomaskovacs.tommy_movies.extension

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.ImageView
import com.bumptech.glide.Glide

inline fun <reified T> Context.startActivity(extras: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(extras))
}

fun Context.loadImage(imageView: ImageView, url: String) {
    Glide.with(this).load(url).into(imageView)
}

@Suppress("DEPRECATION")
fun Context.hasInternetConnection(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        capabilities != null && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
    } else {
        connectivityManager.activeNetworkInfo != null
    }
}
