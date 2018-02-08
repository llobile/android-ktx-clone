package com.llobile.android.ktx.clone.view

import android.view.View
import android.view.ViewTreeObserver

fun View.isVisible(): Boolean = visibility == View.VISIBLE

fun View.doOnPreDraw(action: ViewTreeObserver.() -> Boolean) {
    val viewTreeObserver = this.viewTreeObserver
    viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
        override fun onPreDraw(): Boolean {
            viewTreeObserver.removeOnPreDrawListener(this)
            return action(viewTreeObserver)
        }
    })
}