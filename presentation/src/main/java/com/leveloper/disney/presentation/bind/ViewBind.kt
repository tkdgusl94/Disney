package com.leveloper.disney.presentation.bind

import android.view.View
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.databinding.BindingAdapter
import com.leveloper.disney.presentation.base.Event
import com.leveloper.disney.presentation.ext.showToast
import java.util.function.Function

@BindingAdapter("toast")
fun View.bindToast(message: Event<String>?) {
    message?.getContentIfNotHandled()?.let {
        context?.showToast(it)
    }
}

@BindingAdapter(value = ["onBackPressed", "action"], requireAll = false)
fun View.bindOnBackPressed(onBackPressed: Boolean, action: Function0<Boolean>?) {
    val context = this.context
    if (onBackPressed && context is OnBackPressedDispatcherOwner) {
        setOnClickListener {
            if (action == null || action.invoke()) {
                context.onBackPressedDispatcher.onBackPressed()
            }
        }
    }
}

@BindingAdapter("gone")
fun View.bindGone(shouldBeGone: Boolean) {
    visibility = if (shouldBeGone) View.GONE else View.VISIBLE
}