package com.siziksu.domain.usecase.user

import com.siziksu.domain.repository.BackendRepositoryContract

class GetUser(private val backendRepository: BackendRepositoryContract) : GetUserContract {

    override suspend fun execute(params: GetUserContract.Param) = backendRepository.getUser(params.userId)
}
