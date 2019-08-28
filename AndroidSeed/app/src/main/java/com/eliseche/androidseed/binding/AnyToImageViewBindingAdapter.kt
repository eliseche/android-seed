package com.eliseche.androidseed.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Display Any Image (URL, Bitmap or ResourceId) on ImageView
 */
@BindingAdapter("img")
fun loadImage(imageView: ImageView, img: Any?) {
    if (img != null) {
        if (img is String && img.isEmpty())
            return

        Glide.with(imageView.context)
                .load(img)
                .into(imageView)
    }
}