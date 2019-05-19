package com.siziksu.ui.di

import com.siziksu.ui.mapper.UserDomainMapper
import org.koin.dsl.module.module

val mapperUiModule = module {

    single { UserDomainMapper() }
}
