package com.siziksu.domain.di

import com.siziksu.domain.usecase.user.GetUser
import com.siziksu.domain.usecase.user.GetUserContract
import org.koin.dsl.module.module

val domainModule = module {

    single<GetUserContract> {
        GetUser(get())
    }
}
