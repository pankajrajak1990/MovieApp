package com.pankaj.movieapp

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun RecyclerView.addOnItemClick(listener: RecyclerItemClickListener.OnClickListener) {
    this.addOnChildAttachStateChangeListener(RecyclerItemClickListener(this, listener, null))
}

fun Int.inValid() = this < 0

@BindingAdapter(value = ["app:imageurl", "app:placeholder"], requireAll = false)
fun loadImage(view: ImageView, image: String?, placeholder: Drawable?) {
    val imageUrl = image ?: ""
    Glide.with(view.context)
        .load(imageUrl)
        .also { glide ->
            placeholder?.also { drawable ->
                val requestOptions = RequestOptions().placeholder(drawable)
                glide.apply(requestOptions)
            }
        }.into(view)
}
