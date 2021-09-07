package com.tomaskovacs.tommy_movies

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

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
