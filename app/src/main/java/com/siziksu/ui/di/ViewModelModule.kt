package com.siziksu.ui.di

import com.siziksu.ui.view.detail.UserViewModelProvider
import com.siziksu.ui.view.users.UsersViewModelProvider
import org.koin.dsl.module.module

val presenterModule = module {

    single { UsersViewModelProvider(get(), get()) }

    single { UserViewModelProvider(get(), get()) }
}
