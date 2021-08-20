package com.leveloper.disney.presentation.feature.main

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.leveloper.disney.domain.repository.DisneyRepository
import com.leveloper.disney.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val disneyRepository: DisneyRepository
) : BaseViewModel() {

    val charactersFlow = disneyRepository.getCharactersAsFlow()
        .flowOn(Dispatchers.Default)
        .cachedIn(viewModelScope)
}