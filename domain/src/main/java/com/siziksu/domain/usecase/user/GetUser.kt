package com.siziksu.domain.usecase.user

import com.siziksu.domain.common.CoroutineCase
import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.repository.BackendRepositoryContract

class GetUser(private val backendRepository: BackendRepositoryContract) : CoroutineCase<UserDomain, GetUser.Params>() {

    override suspend fun func(params: Params) = backendRepository.getUser(params.userId)

    class Params(val userId: Int)
}
