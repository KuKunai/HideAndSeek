@file:JvmName("ExtensionsUtils")

package com.minipg.kont.kotlin_feed.commons.extensions

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.minipg.knot.hideseek.R
import com.squareup.picasso.Picasso


fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        Picasso.with(context).load(R.drawable.picture_01).into(this)
    } else {
        Picasso.with(context).load(imageUrl).into(this)
    }
}