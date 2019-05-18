package com.siziksu.ui.di

import com.siziksu.ui.view.mapper.UserDomainMapper
import org.koin.dsl.module.module

val mapperUiModule = module {

    single { UserDomainMapper() }
}
