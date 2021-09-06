package com.tomaskovacs.tommy_movies.activity

import com.tomaskovacs.tommy_movies.base.BaseActivity
import com.tomaskovacs.tommy_movies.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun getBindingClass(): ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
}
