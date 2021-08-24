package com.leveloper.disney.presentation.feature.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import com.leveloper.disney.presentation.R
import com.leveloper.disney.presentation.base.BindingActivity
import com.leveloper.disney.presentation.databinding.ActivityCharacterDetailBinding
import com.leveloper.disney.presentation.ext.showToast
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_character_detail, menu)

        return super.onCreateOptionsMenu(menu)
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