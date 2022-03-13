package com.example.beersappmvparchitecture.utils

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.onScrollHitBottom(action: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                action.invoke()
            }
        }
    })
}
