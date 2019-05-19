package com.siziksu.ui.view.detail

import com.siziksu.ui.common.base.PresenterContract
import com.siziksu.ui.model.User

interface UserDetailContract {

    interface View {

        fun showUser(user: User?)

        fun showError(message: String)
    }

    abstract class Presenter<V : View> : PresenterContract() {

        abstract fun getUser(artistId: Int?)
    }
}
