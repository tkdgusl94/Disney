package com.leveloper.disney.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private val _handleError by lazy { MutableLiveData<Event<String?>>() }
    val handleError: LiveData<Event<String?>> by lazy { _handleError }

    fun handleError(errorMessage: String?) {
        _handleError.postValue(Event(errorMessage))
    }
}