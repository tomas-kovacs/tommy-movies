package com.tomaskovacs.tommy_movies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

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
}