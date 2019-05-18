package com.siziksu.ui

import android.app.Application
import com.siziksu.ui.di.startInjector

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startInjector()
    }
}
