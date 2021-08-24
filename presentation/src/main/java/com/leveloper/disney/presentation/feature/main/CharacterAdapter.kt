package com.leveloper.disney.presentation.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.leveloper.disney.domain.model.CharacterSnippet
import com.leveloper.disney.presentation.databinding.ItemCharacterBinding
import com.leveloper.disney.presentation.ext.setOnSingleClickListener

class CharacterAdapter(private val onItemClick: (id: Int) -> Unit) : PagingDataAdapter<CharacterSnippet, CharacterAdapter.CharacterViewHolder>(diffCallback) {

    private lateinit var layoutInflater: LayoutInflater

    override fun getItemViewType(position: Int) = VIEW_TYPE

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        if (!::layoutInflater.isInitialized) {
            layoutInflater = LayoutInflater.from(parent.context)
        }

        return CharacterViewHolder(ItemCharacterBinding.inflate(layoutInflater, parent, false)).apply {
            this.itemView.setOnSingleClickListener {
                val item = getItem(bindingAdapterPosition) ?: return@setOnSingleClickListener
                onItemClick(item.id)
            }
        }
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position) ?: return)
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterSnippet) {
            binding.character = character
        }
    }

    companion object {
        const val VIEW_TYPE = 100

        private val diffCallback = object : DiffUtil.ItemCallback<CharacterSnippet>() {
            override fun areItemsTheSame(oldItem: CharacterSnippet, newItem: CharacterSnippet): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CharacterSnippet, newItem: CharacterSnippet): Boolean {
                return oldItem == newItem
            }
        }
    }
}