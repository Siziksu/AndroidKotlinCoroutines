package com.siziksu.data.di.modules

import com.siziksu.data.mapper.UserDataMapper
import org.koin.dsl.module.module

val mapperDataModule = module {

    single { UserDataMapper() }
}
