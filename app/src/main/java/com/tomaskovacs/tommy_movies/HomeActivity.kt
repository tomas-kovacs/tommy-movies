package com.tomaskovacs.tommy_movies

import com.tomaskovacs.tommy_movies.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun getBindingClass(): ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
}
