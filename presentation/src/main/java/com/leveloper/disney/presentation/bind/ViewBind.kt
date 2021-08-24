package com.leveloper.disney.presentation.bind

import android.view.View
import androidx.databinding.BindingAdapter
import com.leveloper.disney.presentation.base.Event
import com.leveloper.disney.presentation.ext.showToast

@BindingAdapter("toast")
fun View.bindToast(message: Event<String>?) {
    message?.getContentIfNotHandled()?.let {
        context?.showToast(it)
    }
}