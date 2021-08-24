package com.leveloper.disney.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingActivity<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int)
    : AppCompatActivity(layoutResId) {

    protected val binding: B by lazy { DataBindingUtil.setContentView(this, layoutResId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding {
            lifecycleOwner = this@BindingActivity
        }
    }

    protected inline fun binding(action: B.() -> Unit) {
        binding.run(action)
    }
}