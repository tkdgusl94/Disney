package com.leveloper.disney.presentation.feature.main

import androidx.activity.viewModels
import com.leveloper.disney.presentation.R
import com.leveloper.disney.presentation.base.BaseActivity
import com.leveloper.disney.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun setBindings() {
        // no-op
    }
}