package com.siziksu.ui.di

import com.siziksu.ui.view.main.MainContract
import com.siziksu.ui.view.main.MainPresenter
import org.koin.dsl.module.module

val presenterModule = module {

    factory<MainContract.Presenter<MainContract.View>> { (view: MainContract.View) -> MainPresenter(view, get(), get()) }
}
