package com.example.beersappmvparchitecture.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import com.example.beersappmvparchitecture.R

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.fadeInAnimation() {
    val animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
    startAnimation(animation)
}
