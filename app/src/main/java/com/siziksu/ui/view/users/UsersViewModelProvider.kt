package com.siziksu.ui.view.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siziksu.domain.common.CoroutineCaseContract
import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.usecase.user.GetUsers
import com.siziksu.ui.mapper.UserDomainMapper

class UsersViewModelProvider(
    private val getUsers: CoroutineCaseContract<List<UserDomain>, GetUsers.Params>,
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
