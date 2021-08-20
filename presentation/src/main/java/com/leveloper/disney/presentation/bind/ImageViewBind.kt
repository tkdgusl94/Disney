package com.leveloper.disney.presentation.bind

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder

@BindingAdapter("loadImage")
fun SimpleDraweeView.loadImage(url: String?) {
    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .centerCrop()
        .thumbnail(0.5f)
        .into(this)
}

@BindingAdapter("setDrawable")
fun ImageView.setDrawable(drawable: Drawable) {
    setImageDrawable(drawable)
}