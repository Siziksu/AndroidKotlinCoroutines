package com.siziksu.ui.view.mapper

import com.siziksu.domain.model.UserDomain
import com.siziksu.ui.view.common.Mapper
import com.siziksu.ui.view.model.User

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
