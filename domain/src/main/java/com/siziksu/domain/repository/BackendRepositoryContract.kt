package com.siziksu.domain.repository

import com.siziksu.domain.model.UserDomain

interface BackendRepositoryContract {

    suspend fun getUsers(): List<UserDomain>

    suspend fun getUser(userId: Int): UserDomain
}
