package com.siziksu.ui.mocks

import com.siziksu.domain.model.UserDomain

class UserDomainBuilder {

    fun getUserDomain(id: Int): UserDomain = UserDomain(
        id,
        "name",
        "username",
        "email",
        "phone",
        "website"
    )

    fun getUserDomainList(ids: List<Int>): List<UserDomain> {
        val userDomainList = arrayListOf<UserDomain>()
        ids.forEach { userDomainList.add(getUserDomain(it)) }
        return userDomainList
    }
}
