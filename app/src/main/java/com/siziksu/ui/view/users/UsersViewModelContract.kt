package com.siziksu.ui.view.users

import androidx.lifecycle.MutableLiveData
import com.siziksu.ui.common.base.ViewModelContract
import com.siziksu.ui.model.User

abstract class UsersViewModelContract : ViewModelContract() {

    val usersLiveData = MutableLiveData<List<User>>()
    val errorLiveData = MutableLiveData<String>()
    val progressLiveData = MutableLiveData<Boolean>()

    abstract fun getUsers()
}