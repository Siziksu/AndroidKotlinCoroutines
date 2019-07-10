package com.siziksu.ui.di

import android.app.Application
import com.siziksu.data.di.dataModules
import com.siziksu.domain.di.domainModules
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module

fun Application.startInjector() {
    val list = ArrayList<Module>()
    list.addAll(appModules())
    list.addAll(domainModules())
    list.addAll(dataModules())
    return startKoin(this, list)
}

fun appModules(): List<Module> {
    return listOf(
        viewModelModule,
        mapperUiModule
    )
}
