package com.leveloper.disney.presentation.feature.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.leveloper.disney.presentation.R
import com.leveloper.disney.presentation.base.BindingActivity
import com.leveloper.disney.presentation.databinding.ActivityCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailActivity : BindingActivity<ActivityCharacterDetailBinding>(R.layout.activity_character_detail) {

    private val viewModel: CharacterDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding {
            vm = viewModel
        }
    }

    companion object {
        const val EXTRA_CHARACTER_ID = "EXTRA_CHARACTER_ID"

        operator fun invoke(context: Context, characterId: Int): Intent {
            return Intent(context, CharacterDetailActivity::class.java).apply {
                putExtra(EXTRA_CHARACTER_ID, characterId)
            }
        }
    }
}