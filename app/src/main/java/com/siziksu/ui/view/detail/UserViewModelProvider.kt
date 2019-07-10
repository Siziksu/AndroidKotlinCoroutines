package com.siziksu.ui.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.siziksu.domain.common.CoroutineCaseContract
import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.usecase.user.GetUser
import com.siziksu.ui.mapper.UserDomainMapper

class UserViewModelProvider(
    private val getUser: CoroutineCaseContract<UserDomain, GetUser.Params>,
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
