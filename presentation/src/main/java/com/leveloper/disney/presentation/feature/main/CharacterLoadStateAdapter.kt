package com.leveloper.disney.presentation.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leveloper.disney.presentation.databinding.ItemCharactersLoadStateBinding
import com.leveloper.disney.presentation.ext.setOnSingleClickListener

class CharacterLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<CharacterLoadStateAdapter.CharacterLoadStateViewHolder>() {

    override fun getStateViewType(loadState: LoadState) = VIEW_TYPE

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): CharacterLoadStateViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterLoadStateViewHolder(ItemCharactersLoadStateBinding.inflate(layoutInflater, parent, false), retry)
    }

    override fun onBindViewHolder(holder: CharacterLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class CharacterLoadStateViewHolder(
        private val binding: ItemCharactersLoadStateBinding,
        private val retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(state: LoadState) {
            binding.btnRetry.setOnSingleClickListener { retry() }
            binding.isLoading = state is LoadState.Loading
            binding.isError = state is LoadState.Error
            binding.errorMessage = (state as? LoadState.Error)?.error?.message ?: ""
        }
    }

    companion object {
        const val VIEW_TYPE = 200
    }
}