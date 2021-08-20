package com.leveloper.disney.presentation.feature.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.leveloper.disney.presentation.R
import com.leveloper.disney.presentation.base.BaseActivity
import com.leveloper.disney.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()

    private val adapter: CharacterAdapter by lazy { CharacterAdapter() }

    override fun setBindings() {
        // no-op
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.rvCharacters.adapter = adapter

        lifecycleScope.launch {
            viewModel.charactersFlow.collectLatest {
                adapter.submitData(it)
            }
        }
    }
}