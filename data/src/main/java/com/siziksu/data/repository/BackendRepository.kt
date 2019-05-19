package com.siziksu.data.repository

import com.siziksu.data.common.utils.Logs
import com.siziksu.data.datasource.backend.BackendDataSourceContract
import com.siziksu.data.mapper.UserDataMapper
import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.repository.BackendRepositoryContract

class BackendRepository(
    private val backendDataSource: BackendDataSourceContract,
    private val userDataMapper: UserDataMapper
) : BackendRepositoryContract {

    override suspend fun getUsers(): List<UserDomain> {
        try {
            return userDataMapper.map(backendDataSource.getUsers())
        } catch (e: Exception) {
            Logs.error("Error: " + e.message)
            throw e
        }
    }

    override suspend fun getUser(userId: Int): UserDomain {
        try {
            return userDataMapper.map(backendDataSource.getUser(userId))
        } catch (e: Exception) {
            Logs.error("Error: " + e.message)
            throw e
        }
    }
}
