package com.leveloper.disney.presentation.feature.detail

import androidx.lifecycle.SavedStateHandle
import com.leveloper.disney.domain.repository.DisneyRepository
import com.leveloper.disney.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val disneyRepository: DisneyRepository
) : BaseViewModel() {

    private val characterId = savedStateHandle.get<Int>(EXTRA_CHARACTER_ID)

    init {
        println("id: $characterId")
    }

    companion object {
        const val EXTRA_CHARACTER_ID = "EXTRA_CHARACTER_ID"
    }
}