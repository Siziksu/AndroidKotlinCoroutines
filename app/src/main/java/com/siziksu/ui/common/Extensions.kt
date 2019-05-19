package com.siziksu.ui.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <B : Any, L : LiveData<B>> LifecycleOwner.observe(liveData: L, body: (B?) -> Unit) {
    liveData.observe(this, Observer(body))
}
