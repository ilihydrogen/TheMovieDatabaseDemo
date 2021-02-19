package ru.mikhailskiy.intensiv.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadByUrl(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}