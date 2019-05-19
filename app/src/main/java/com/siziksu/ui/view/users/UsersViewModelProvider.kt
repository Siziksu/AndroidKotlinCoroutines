package com.siziksu.ui.view.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siziksu.domain.usecase.user.GetUsersContract
import com.siziksu.ui.mapper.UserDomainMapper

class UsersViewModelProvider(
    private val getUsers: GetUsersContract,
    private val userDomainMapper: UserDomainMapper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UsersViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UsersViewModel(getUsers, userDomainMapper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
