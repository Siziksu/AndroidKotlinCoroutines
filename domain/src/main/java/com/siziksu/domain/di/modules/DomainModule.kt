package com.siziksu.domain.di.modules

import com.siziksu.domain.common.CoroutineCaseContract
import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.usecase.user.GetUser
import com.siziksu.domain.usecase.user.GetUsers
import org.koin.dsl.module.module

const val GET_USER = "GetUser"
const val GET_USERS = "GetUsers"

val domainModule = module {

    single<CoroutineCaseContract<UserDomain, GetUser.Params>>(GET_USER) { GetUser(get()) }

    single<CoroutineCaseContract<List<UserDomain>, GetUsers.Params>>(GET_USERS) { GetUsers(get()) }
}
