package com.siziksu.ui.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siziksu.domain.usecase.user.GetUserContract
import com.siziksu.ui.mapper.UserDomainMapper

class UserViewModelProvider(
    private val getUser: GetUserContract,
    private val userDomainMapper: UserDomainMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(getUser, userDomainMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
