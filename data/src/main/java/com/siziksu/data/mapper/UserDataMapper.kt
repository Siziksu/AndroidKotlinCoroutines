package com.siziksu.data.mapper

import com.siziksu.data.common.Mapper
import com.siziksu.data.model.UserData
import com.siziksu.domain.model.UserDomain

class UserDataMapper : Mapper<UserData, UserDomain>() {

    override fun map(unmapped: UserData) = UserDomain(
        unmapped.id,
        unmapped.name,
        unmapped.username,
        unmapped.email,
        unmapped.phone,
        unmapped.website
    )
}