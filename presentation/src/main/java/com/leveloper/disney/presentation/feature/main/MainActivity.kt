package com.leveloper.disney.presentation.feature.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leveloper.disney.presentation.R
import com.leveloper.disney.presentation.base.BaseActivity
import com.leveloper.disney.presentation.databinding.ActivityMainBinding
import com.leveloper.disney.presentation.feature.detail.CharacterDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

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

    override fun setBindings() {
        // no-op
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setCharactersRecyclerView(binding.rvCharacters)

        lifecycleScope.launch {
            viewModel.charactersFlow.collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }

    private fun setCharactersRecyclerView(recyclerView: RecyclerView) {
        val config = ConcatAdapter.Config.Builder()
            .setIsolateViewTypes(false)
            .build()

        val adapter = ConcatAdapter(config, characterAdapter, loadStateAdapter)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(this, 2).apply {
            spanSizeLookup = object: GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (adapter.getItemViewType(position)) {
                        CharacterAdapter.VIEW_TYPE -> 1
                        else -> 2
                    }
                }
            }
        }
    }

    private fun openDetail(characterId: Int) {
        startActivity(CharacterDetailActivity(this, characterId))
    }
}