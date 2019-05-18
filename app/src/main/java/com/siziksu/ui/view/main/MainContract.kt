package com.siziksu.ui.view.main

import com.siziksu.ui.view.common.base.PresenterContract
import com.siziksu.ui.view.model.User

interface MainContract {

    interface View {

        fun showUser(user: User?)

        fun showError(message: String)
    }

    abstract class Presenter<V : View> : PresenterContract() {

        abstract fun getUser()
    }
}
