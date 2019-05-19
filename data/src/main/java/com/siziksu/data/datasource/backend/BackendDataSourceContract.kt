package com.siziksu.data.datasource.backend

import com.siziksu.data.model.UserData

interface BackendDataSourceContract {

    suspend fun getUsers(): List<UserData>

    suspend fun getUser(userId: Int): UserData
}