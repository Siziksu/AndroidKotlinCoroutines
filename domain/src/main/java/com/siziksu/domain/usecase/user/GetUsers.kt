package com.siziksu.domain.usecase.user

import com.siziksu.domain.repository.BackendRepositoryContract

class GetUsers(private val backendRepository: BackendRepositoryContract) : GetUsersContract {

    override suspend fun execute(params: GetUsersContract.Param) = backendRepository.getUsers()
}
