package com.siziksu.ui.di

import androidx.lifecycle.ViewModelProvider
import com.siziksu.ui.view.detail.UserViewModelProvider
import com.siziksu.ui.view.users.UsersViewModelProvider
import org.koin.dsl.module.module

const val USER_VIEW_MODEL = "User ViewModel"
const val USERS_VIEW_MODEL = "Users ViewModel"

val viewModelModule = module {

    single<ViewModelProvider.Factory>(USER_VIEW_MODEL) { UserViewModelProvider(get(), get()) }

    single<ViewModelProvider.Factory>(USERS_VIEW_MODEL) { UsersViewModelProvider(get(), get()) }
}
