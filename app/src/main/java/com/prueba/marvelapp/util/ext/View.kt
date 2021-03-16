package com.prueba.marvelapp.util.ext

import android.content.ClipData
import android.content.ClipDescription
import android.view.View
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import com.bumptech.glide.Glide
import com.prueba.marvelapp.util.MyDragShadowBuilder

fun ImageView.loadImageFromLink(link: String?) {
    if (!link.isNullOrEmpty())
        Glide.with(context.applicationContext)
            .load(link)
            //.signature(StringSignature(link))
            //.dontAnimate()
            //.placeholder(R.drawable.ic_image)
            .into(this)
}

