package com.siziksu.ui.di

import androidx.lifecycle.ViewModelProvider
import com.siziksu.domain.di.modules.GET_USER
import com.siziksu.domain.di.modules.GET_USERS
import com.siziksu.ui.view.detail.UserViewModelProvider
import com.siziksu.ui.view.users.UsersViewModelProvider
import org.koin.dsl.module.module

const val USER_VIEW_MODEL = "User ViewModel"
const val USERS_VIEW_MODEL = "Users ViewModel"

val viewModelModule = module {

    factory<ViewModelProvider.Factory>(USER_VIEW_MODEL) { UserViewModelProvider(get(GET_USER), get()) }

    factory<ViewModelProvider.Factory>(USERS_VIEW_MODEL) { UsersViewModelProvider(get(GET_USERS), get()) }
}
