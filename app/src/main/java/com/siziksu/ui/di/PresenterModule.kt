package com.siziksu.ui.di

import com.siziksu.ui.view.detail.UserDetailContract
import com.siziksu.ui.view.detail.UserDetailPresenter
import com.siziksu.ui.view.users.UsersContract
import com.siziksu.ui.view.users.UsersPresenter
import org.koin.dsl.module.module

val presenterModule = module {

    factory<UsersContract.Presenter<UsersContract.View>> { (view: UsersContract.View) -> UsersPresenter(view, get(), get()) }

    factory<UserDetailContract.Presenter<UserDetailContract.View>> { (view: UserDetailContract.View) -> UserDetailPresenter(view, get(), get()) }
}
