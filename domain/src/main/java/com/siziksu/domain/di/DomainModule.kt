package com.siziksu.domain.di

import com.siziksu.domain.usecase.user.GetUser
import com.siziksu.domain.usecase.user.GetUserContract
import com.siziksu.domain.usecase.user.GetUsers
import com.siziksu.domain.usecase.user.GetUsersContract
import org.koin.dsl.module.module

val domainModule = module {

    single<GetUsersContract> { GetUsers(get()) }

    single<GetUserContract> { GetUser(get()) }
}
