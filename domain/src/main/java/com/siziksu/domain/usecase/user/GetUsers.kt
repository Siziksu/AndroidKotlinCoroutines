package com.siziksu.domain.usecase.user

import com.siziksu.domain.common.CoroutineCase
import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.repository.BackendRepositoryContract

class GetUsers(private val backendRepository: BackendRepositoryContract) : CoroutineCase<List<UserDomain>, GetUsers.Params>() {

    override suspend fun func(params: Params) = backendRepository.getUsers()

    class Params
}
