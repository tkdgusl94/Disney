package com.leveloper.disney.presentation.feature.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.leveloper.disney.presentation.R
import com.leveloper.disney.presentation.base.BaseActivity
import com.leveloper.disney.presentation.databinding.ActivityCharacterDetailBinding
import com.leveloper.disney.presentation.feature.detail.CharacterDetailViewModel.Companion.EXTRA_CHARACTER_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailActivity : BaseActivity<ActivityCharacterDetailBinding>(R.layout.activity_character_detail) {

    private val viewModel: CharacterDetailViewModel by viewModels()

    override fun setBindings() {
        // no-op
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel
    }

    companion object {

        operator fun invoke(context: Context, characterId: Int): Intent {
            return Intent(context, CharacterDetailActivity::class.java).apply {
                putExtra(EXTRA_CHARACTER_ID, characterId)
            }
        }
    }
}