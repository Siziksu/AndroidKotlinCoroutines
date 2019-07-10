package com.siziksu.data.di

import com.siziksu.data.di.modules.dataSourceModule
import com.siziksu.data.di.modules.mapperDataModule
import com.siziksu.data.di.modules.repositoryModule
import org.koin.dsl.module.Module

fun dataModules(): List<Module> {
    return listOf(
        dataSourceModule,
        repositoryModule,
        mapperDataModule
    )
}
