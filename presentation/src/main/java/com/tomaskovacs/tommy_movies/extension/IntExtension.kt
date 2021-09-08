package com.tomaskovacs.tommy_movies.extension

import java.text.NumberFormat
import java.util.Locale

fun Int.convertToCurrency(): String {
    val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
    format.minimumFractionDigits = 0
    return format.format(this)
}
