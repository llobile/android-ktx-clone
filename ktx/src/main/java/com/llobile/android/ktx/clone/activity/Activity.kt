package com.llobile.android.ktx.clone.activity

import android.app.Activity

inline fun <reified T> Activity.needsToBe() {
    if(this !is T){
        throw Exception("Unsupported Type")
    }
}