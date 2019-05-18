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
}
