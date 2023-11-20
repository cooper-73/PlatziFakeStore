package com.example.platzifakestore.helpers

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrls", "error")
fun ImageView.loadImage(urls: List<String>, errorDrawable: Drawable) {
    Picasso.get().load(urls.firstOrNull()).error(errorDrawable).into(this)
}