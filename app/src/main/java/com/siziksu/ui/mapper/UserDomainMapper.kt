package com.siziksu.ui.mapper

import com.siziksu.domain.model.UserDomain
import com.siziksu.ui.common.Mapper
import com.siziksu.ui.model.User

class UserDomainMapper : Mapper<UserDomain, User>() {

    override fun map(unmapped: UserDomain) = User(
        unmapped.id,
        unmapped.name,
        unmapped.username,
        unmapped.email,
        unmapped.phone,
        unmapped.website
    )
}
