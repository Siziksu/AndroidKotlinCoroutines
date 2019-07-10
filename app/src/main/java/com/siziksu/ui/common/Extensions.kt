package com.siziksu.ui.common

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar

fun <B : Any, L : LiveData<B>> LifecycleOwner.observe(liveData: L, body: (B?) -> Unit) {
    liveData.observe(this, Observer(body))
}

fun Fragment.showSnackbar(layout: View?, message: String): Unit = layout?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show() } ?: Unit

fun Activity.showSnackbar(layout: View?, message: String): Unit = layout?.let { Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show() } ?: Unit
