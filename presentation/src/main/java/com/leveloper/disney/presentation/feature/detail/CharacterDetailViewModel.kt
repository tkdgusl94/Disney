package com.leveloper.disney.presentation.feature.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.leveloper.disney.domain.model.onError
import com.leveloper.disney.domain.model.onSuccess
import com.leveloper.disney.domain.repository.DisneyRepository
import com.leveloper.disney.presentation.base.BaseViewModel
import com.leveloper.disney.presentation.base.Event
import com.leveloper.disney.presentation.feature.detail.CharacterDetailActivity.Companion.EXTRA_CHARACTER_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val disneyRepository: DisneyRepository
) : BaseViewModel() {

    private val characterId = savedStateHandle.get<Int>(EXTRA_CHARACTER_ID) ?: -1

    private val _message = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>> = _message

    init {
        _message.value = Event("hello")

        viewModelScope.launch {
            disneyRepository.getCharacter(characterId)
                .onSuccess {
                    println("character: $it")
                }
                .onError {
                    println("error: $it")
                }
        }
    }

    fun onClickBackButton(): Boolean {
        println("!!!!!!!!!!!!!!!!!!!!!!!!")
        return true
    }
}