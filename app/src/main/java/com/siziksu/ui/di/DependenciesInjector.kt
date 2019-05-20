package com.siziksu.ui.di

import android.app.Application
import com.siziksu.data.di.dataSourceModule
import com.siziksu.data.di.mapperDataModule
import com.siziksu.data.di.repositoryModule
import com.siziksu.domain.di.domainModule
import org.koin.android.ext.android.startKoin

fun Application.startInjector() = startKoin(
    this,
    listOf(
        dataSourceModule,
        repositoryModule,
        domainModule,
        viewModelModule,
        mapperDataModule,
        mapperUiModule
    )
)
