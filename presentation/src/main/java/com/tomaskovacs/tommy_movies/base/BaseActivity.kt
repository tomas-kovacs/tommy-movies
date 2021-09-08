package com.tomaskovacs.tommy_movies.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
    }

    abstract fun getBindingClass(): B

    private fun setBinding() {
        binding = getBindingClass()
        setContentView(binding.root)
    }

    protected fun showGenericError() {
        Snackbar.make(binding.root, "Error", Snackbar.LENGTH_SHORT).show()
    }
}
