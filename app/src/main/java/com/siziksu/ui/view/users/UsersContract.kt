package com.siziksu.ui.view.users

import com.siziksu.ui.common.base.PresenterContract
import com.siziksu.ui.model.User

interface UsersContract {

    interface View {

        fun showUsers(users: List<User>?)

        fun showError(message: String)
    }

    abstract class Presenter<V : View> : PresenterContract() {

        abstract fun getUsers()
    }
}
