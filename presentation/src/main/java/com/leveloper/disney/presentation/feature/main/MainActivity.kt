package com.leveloper.disney.presentation.feature.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.leveloper.disney.presentation.R
import com.leveloper.disney.presentation.base.BindingActivity
import com.leveloper.disney.presentation.databinding.ActivityMainBinding
import com.leveloper.disney.presentation.feature.detail.CharacterDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()

    private val characterAdapter: CharacterAdapter by lazy {
        CharacterAdapter(::openDetail).apply {
            addLoadStateListener { loadStates ->
                loadStateAdapter.loadState = loadStates.append
            }
        }
    }

    private val loadStateAdapter: CharacterLoadStateAdapter by lazy {
        CharacterLoadStateAdapter { characterAdapter.retry() }
    }

    private val adapter by lazy {
        val config = ConcatAdapter.Config.Builder()
            .setIsolateViewTypes(false)
            .build()

        ConcatAdapter(config, characterAdapter, loadStateAdapter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding {
            vm = viewModel
            adapter = this@MainActivity.adapter
            layoutManager = GridLayoutManager(this@MainActivity, 2).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when (this@MainActivity.adapter.getItemViewType(position)) {
                            CharacterAdapter.VIEW_TYPE -> 1
                            else -> 2
                        }
                    }
                }
            }
        }

        lifecycleScope.launch {
            viewModel.charactersFlow.collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }

    private fun openDetail(characterId: Int) {
        startActivity(CharacterDetailActivity(this, characterId))
    }
}