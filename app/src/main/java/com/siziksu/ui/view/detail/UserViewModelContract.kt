package com.siziksu.ui.view.detail

import androidx.lifecycle.MutableLiveData
import com.siziksu.ui.common.base.ViewModelContract
import com.siziksu.ui.model.User

abstract class UserViewModelContract : ViewModelContract() {

    val userLiveData = MutableLiveData<User>()
    val errorLiveData = MutableLiveData<String>()
    val progressLiveData = MutableLiveData<Boolean>()

    abstract fun getUser(userId: Int?)
}