package com.siziksu.domain.di

import com.siziksu.domain.di.modules.domainModule
import org.koin.dsl.module.Module

fun domainModules(): List<Module> {
    return listOf(
        domainModule
    )
}
